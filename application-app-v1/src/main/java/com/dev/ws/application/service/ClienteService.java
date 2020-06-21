package com.dev.ws.application.service;

import java.util.List;
import java.util.Optional;

import com.dev.ws.application.model.Cliente;

public interface ClienteService {

	List<Cliente> findAll();
	
	Cliente saveCliente(Cliente cliente);
	
	Optional<Cliente> findById(Integer clienteId);
	
	void deleteCliente(Cliente cliente);
}