package com.dev.ws.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dev.ws.application.dto.ClienteDTO;
import com.dev.ws.application.facade.ClienteFacade;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteRestController {

	private final ClienteFacade clienteFacade;
	
	@Autowired
	public ClienteRestController(ClienteFacade clienteFacade) {
		this.clienteFacade = clienteFacade;
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO cliente) {
		ClienteDTO clienteResponse = clienteFacade.saveCliente(cliente);
		return new ResponseEntity<ClienteDTO>(clienteResponse, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteDTO>> findAllClientes() {
		List<ClienteDTO> clientes = clienteFacade.findAll();
		return new ResponseEntity<List<ClienteDTO>>(clientes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{clienteId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> getClienteById(@PathVariable(value = "clienteId") Integer clienteId) {
		ClienteDTO cliente = clienteFacade.findById(clienteId)
										.orElseThrow(() -> {
											return new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente No Encontrado");
										});
		return new ResponseEntity<ClienteDTO>(cliente, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{clienteId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteClienteById(@PathVariable(value = "clienteId") Integer clienteId) {
		clienteFacade.findById(clienteId)
					.map((c) -> {
						clienteFacade.deleteCliente(c);
						return Void.TYPE;
					})
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente No Encontrado"));
	}
	
	@PutMapping(value = "/update/{clienteId}")
	public ResponseEntity<ClienteDTO> updateCliente(@PathVariable(value = "clienteId") Integer clienteId,
													@Valid @RequestBody ClienteDTO cliente) {
		ClienteDTO clienteResponse = clienteFacade.findById(clienteId)
												.map((c) -> {
													c.setNombre(cliente.getNombre());
													c.setCpf(cliente.getCpf());
													return clienteFacade.saveCliente(c);
												})
												.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente No Encontrado"));
		return new ResponseEntity<ClienteDTO>(clienteResponse, HttpStatus.CREATED);
	}
}