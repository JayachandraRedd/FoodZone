package com.cassini.foodzone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetOrderRequestDto {
	
	private String status;
	private Integer customerId;
	private Integer vendorId;

}
