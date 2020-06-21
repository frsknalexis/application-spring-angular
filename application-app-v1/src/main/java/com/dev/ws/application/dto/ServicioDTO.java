package com.dev.ws.application.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7045417952050594647L;
	
	private Integer servicioId;
	
	private String descripcion;
	
	private BigDecimal valor;
	
	private ClienteDTO cliente;
}
