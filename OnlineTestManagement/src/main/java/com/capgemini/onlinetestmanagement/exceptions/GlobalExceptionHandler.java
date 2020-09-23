package com.capgemini.onlinetestmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value=UserExceptions.class)
	public ResponseEntity<Object> messageNotFound(UserExceptions userException){
		return new ResponseEntity<>(userException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
