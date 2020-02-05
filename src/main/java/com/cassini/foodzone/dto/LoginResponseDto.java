package com.cassini.foodzone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
	
	private Integer id;
	private String name;
	private Long phoneNumber;
	private String email;

}
