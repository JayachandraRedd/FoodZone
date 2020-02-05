package com.cassini.foodzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.foodzone.dto.RegistrationDto;
import com.cassini.foodzone.dto.ResponseDto;
import com.cassini.foodzone.service.CustomerService;

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
	 */

	@PostMapping("/registration")
	public ResponseDto registration(RegistrationDto registrationDto) {
		log.info("starting registration method , inside CustomerController");

		return customerService.registration(registrationDto);

	}


}
