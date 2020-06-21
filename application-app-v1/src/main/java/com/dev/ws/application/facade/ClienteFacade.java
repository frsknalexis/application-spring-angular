package com.dev.ws.application.facade;

import java.util.List;
import java.util.Optional;

import com.dev.ws.application.dto.ClienteDTO;

public interface ClienteFacade {

	List<ClienteDTO> findAll();
	
	ClienteDTO saveCliente(ClienteDTO cliente);
	
	Optional<ClienteDTO> findById(Integer clienteId);
	
	void deleteCliente(ClienteDTO cliente);
}