package com.cassini.foodzone.service;

import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;
import com.cassini.foodzone.dto.RegistrationDto;
import com.cassini.foodzone.dto.ResponseDto;
import com.cassini.foodzone.exception.NotFoundException;

public interface CustomerService {
	
	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto) throws NotFoundException;

	public ResponseDto registration(RegistrationDto registrationDto);

}
