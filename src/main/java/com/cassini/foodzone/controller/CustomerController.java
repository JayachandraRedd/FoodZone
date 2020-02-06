package com.cassini.foodzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.foodzone.dto.RegistrationDto;
import com.cassini.foodzone.dto.ResponseDto;
import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;
import com.cassini.foodzone.exception.NotFoundException;
import com.cassini.foodzone.exception.RegistrationFailedExcpetion;
import com.cassini.foodzone.service.CustomerService;
import com.cassini.foodzone.util.Constant;

import lombok.extern.slf4j.Slf4j;
/**
 * The LocationController program implements an application flightbooking
 * 
 * @author Amala
 * @version 1.0
 * @since 2020-02-04
 *
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * 
	 * @param registrationDto is the parameter for register() method
	 * @return ResponseDto
	 * @throws RegistrationFailedExcpetion 
	 */

	@PostMapping("/registration")
	public ResponseDto registration(@RequestBody RegistrationDto registrationDto) throws RegistrationFailedExcpetion {
		log.info("starting registration method , inside CustomerController");

		return customerService.registration(registrationDto);

	}

	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> authenticateCustomer(@RequestBody LoginRequestDto loginRequestDto) throws NotFoundException{
		if(loginRequestDto.getEmail().isEmpty()) {
			log.error("CustomerController controller ---> email is missing");
			throw new NotFoundException(Constant.EMAIL_NOT_FOUND);
			
		} else if(loginRequestDto.getPassword().isEmpty()) {
			log.error("CustomerController controller ---> password is missing");
			throw new NotFoundException(Constant.PASS_NOT_FOUND);
		}
		return ResponseEntity.ok().body(customerService.authenticateCustomer(loginRequestDto));
	}
	
	

}
