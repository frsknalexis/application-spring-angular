package com.dev.ws.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dev.ws.application.model.Cliente;
import com.dev.ws.application.repository.ClienteRepository;
import com.dev.ws.application.service.ClienteService;
import com.dev.ws.application.util.LocalDateUtil;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		if (cliente.getClienteId() != null && cliente.getClienteId().intValue() > 0) {
			return clienteRepository.save(cliente);
		}
		cliente.setFechaRegistro(LocalDateUtil.getLocalDate.get());
		return clienteRepository.save(cliente);
	}

	@Override
	public Optional<Cliente> findById(Integer clienteId) {
		return clienteRepository.findById(clienteId);
	}

	@Override
	public void deleteCliente(Cliente cliente) {
		clienteRepository.findById(cliente.getClienteId())
						.ifPresent((c) -> {
							clienteRepository.delete(c);
						});
	}
}