package com.dev.ws.application.exception;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiErrors implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8887031484071644283L;

	private List<String> errors;
	
	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public ApiErrors(String message) {
		this.errors = Arrays.asList(message);
	}
}