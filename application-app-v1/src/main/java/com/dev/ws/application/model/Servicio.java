package com.dev.ws.application.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_servicios", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -231464899515673336L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "servicio_id", nullable = false, unique = true)
	private Integer servicioId;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
}