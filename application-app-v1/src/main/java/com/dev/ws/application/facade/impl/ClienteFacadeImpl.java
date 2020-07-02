package com.dev.ws.application.facade.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.ws.application.dto.ClienteDTO;
import com.dev.ws.application.facade.ClienteFacade;
import com.dev.ws.application.model.Cliente;
import com.dev.ws.application.service.ClienteService;

@Component
public class ClienteFacadeImpl implements ClienteFacade {

	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;
	
	@Autowired
	ModelMapper modelMapper;
	
	private <T, R> R convertObject(T t, Function<T, R> function) {
		return function.apply(t);
	}
	
	@Override
	public List<ClienteDTO> findAll() {
		return clienteService.findAll()
				.stream()
				.map((c) -> {
					return convertObject(c, (cl) -> {
						return modelMapper.map(cl, ClienteDTO.class);
						});
					})
				.collect(Collectors.toList());
	}

	@Override
	public ClienteDTO saveCliente(ClienteDTO cliente) {
		Cliente clienteResponse = clienteService.saveCliente(convertObject(cliente, 
				(c) -> {
					return modelMapper.map(c, Cliente.class);
					}));
		return convertObject(clienteResponse, (c) -> {
			return modelMapper.map(c, ClienteDTO.class);
		});
	}

	@Override
	public Optional<ClienteDTO> findById(Integer clienteId) {
		return clienteService.findById(clienteId)
				.map((c) -> {
					return convertObject(c, (cl) -> {
						return modelMapper.map(cl, ClienteDTO.class);
						});
					});
	}

	@Override
	public void deleteCliente(ClienteDTO cliente) {
		clienteService.deleteCliente(convertObject(cliente, 
				(c) -> {
					return modelMapper.map(c, Cliente.class);
				}));
	}
}