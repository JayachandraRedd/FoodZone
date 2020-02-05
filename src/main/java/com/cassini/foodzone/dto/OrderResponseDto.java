package com.cassini.foodzone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
	
	private Integer orderId;
	private String message;
	private Integer statusCode;

}
