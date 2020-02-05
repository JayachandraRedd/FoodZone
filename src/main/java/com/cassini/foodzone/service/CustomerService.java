package com.cassini.foodzone.service;

import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;

public interface CustomerService {
	
	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto);

}
