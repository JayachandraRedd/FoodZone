package com.cassini.foodzone.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationDto {

	private String customerName;
	private String password;
	private String email;
	private Long phoneNumber;

}
