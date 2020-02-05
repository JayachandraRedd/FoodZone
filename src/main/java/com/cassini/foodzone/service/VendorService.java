package com.cassini.foodzone.service;

import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;
import com.cassini.foodzone.dto.RegisterVendorRequestDto;
import com.cassini.foodzone.dto.RegisterVendorResponseDto;
import com.cassini.foodzone.exception.NotFoundException;

public interface VendorService {
	
	public LoginResponseDto authenticateVendor(LoginRequestDto loginRequestDto) throws NotFoundException;
	
	public RegisterVendorResponseDto registerVendor(RegisterVendorRequestDto registerVendorRequestDto);

}
