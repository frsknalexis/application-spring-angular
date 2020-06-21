package com.dev.ws.application.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
		List<String> errorMessages = errorList.stream()
											.map((fieldError) -> {
												return fieldError.getDefaultMessage();
											})
											.collect(Collectors.toList());
		
		ApiErrors apiErrors = ApiErrors.builder()
									.errors(errorMessages)
									.build();
		
		return new ResponseEntity<>(apiErrors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ResponseStatusException.class)
	public ResponseEntity<?> handleResponseStatusException(ResponseStatusException ex) {
		String message = ex.getMessage();
		HttpStatus httpStatusResponse = ex.getStatus();
		ApiErrors apiErrors = new ApiErrors(message);
		return new ResponseEntity<>(apiErrors, httpStatusResponse);
	}
}