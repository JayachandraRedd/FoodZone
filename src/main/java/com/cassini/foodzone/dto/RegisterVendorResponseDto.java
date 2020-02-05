package com.cassini.foodzone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterVendorResponseDto {
	
	private String password;
	private String message;
	private Integer statusCode;

}
