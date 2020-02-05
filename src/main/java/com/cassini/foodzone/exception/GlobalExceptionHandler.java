package com.cassini.foodzone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cassini.foodzone.dto.ErrorDto;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDto> dateNotFoundException(NotFoundException e){
		ErrorDto errorDto = new ErrorDto();
		errorDto.setMessage(e.getMessage());
		errorDto.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
	}
	
	
	
}