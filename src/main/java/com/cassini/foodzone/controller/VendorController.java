package com.cassini.foodzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;
import com.cassini.foodzone.dto.RegisterVendorRequestDto;
import com.cassini.foodzone.dto.RegisterVendorResponseDto;
import com.cassini.foodzone.exception.NotFoundException;
import com.cassini.foodzone.service.VendorService;
import com.cassini.foodzone.util.Constant;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/vendors")
@Slf4j
public class VendorController {

	@Autowired
	VendorService vendorService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> authenticateVendor(@RequestBody LoginRequestDto loginRequestDto)
			throws NotFoundException {
		
		if (loginRequestDto.getEmail().isEmpty()) {
			log.error("VendorController controller authenticateVendor---> email is missing");
			throw new NotFoundException(Constant.EMAIL_NOT_FOUND);

		} else if (loginRequestDto.getPassword().isEmpty()) {
			log.error("VendorController controller authenticateVendor---> password is missing");
			throw new NotFoundException(Constant.PASS_NOT_FOUND);
		}
		return ResponseEntity.ok().body(vendorService.authenticateVendor(loginRequestDto));
	}

	@PostMapping
	public ResponseEntity<RegisterVendorResponseDto> registerVnedor(
			@RequestBody RegisterVendorRequestDto registerVendorRequestDto) {
		
		RegisterVendorResponseDto registerVendorResponseDto =  vendorService.registerVendor(registerVendorRequestDto);
		registerVendorResponseDto.setMessage("vendor registered successfully");
		registerVendorResponseDto.setStatusCode(HttpStatus.ACCEPTED.value());
		return ResponseEntity.ok().body(registerVendorResponseDto);

	}
}
