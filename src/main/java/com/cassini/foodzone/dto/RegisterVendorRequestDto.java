package com.cassini.foodzone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterVendorRequestDto {
	
	private String vendorName;
	private String email;
	private Long phoneNumber;

}
