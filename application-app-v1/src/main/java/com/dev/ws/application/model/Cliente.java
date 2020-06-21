package com.dev.ws.application.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_clientes", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7468847149355995331L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id", nullable = false, unique = true)
	private Integer clienteId;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "fecha_registro")
	private LocalDate fechaRegistro;
}