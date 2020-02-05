package com.cassini.foodzone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
	
	private String message;
	private Integer statusCode;

}
