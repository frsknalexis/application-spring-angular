package com.dev.ws.application.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -777469101370439797L;
	
	private Integer clienteId;
	
	@NotEmpty(message = "{campo.nombre.obligatorio}")
	private String nombre;
	
	@NotEmpty(message = "{campo.cpf.obligatorio}")
	private String cpf;
	
	private LocalDate fechaRegistro;
}