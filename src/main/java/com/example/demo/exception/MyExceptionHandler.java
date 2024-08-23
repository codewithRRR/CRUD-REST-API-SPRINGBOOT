package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<String>  handlerException(DataNotFoundException  exception)
	{
		return new ResponseEntity<String>(exception.message, HttpStatus.NOT_FOUND);
		
	}
	
}


