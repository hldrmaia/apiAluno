package com.tobrasil.apiAluno.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException) {
		ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails
				.builder()
				.withTimestamp(new Date().getTime())
				.withStatus(HttpStatus.NOT_FOUND.value())
				.withTitle("Resource Not Found")
				.withDetail(rnfException.getMessage())
				.withDevMsg(rnfException.getClass().getName())
				.build();

		return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
	}
}
