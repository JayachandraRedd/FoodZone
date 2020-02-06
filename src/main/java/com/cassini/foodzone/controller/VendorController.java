package com.cassini.foodzone.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;
import com.cassini.foodzone.dto.RegisterVendorRequestDto;
import com.cassini.foodzone.dto.RegisterVendorResponseDto;
import com.cassini.foodzone.entity.Vendor;
import com.cassini.foodzone.exception.NotFoundException;
import com.cassini.foodzone.service.VendorService;
import com.cassini.foodzone.util.Constant;

import lombok.extern.slf4j.Slf4j;

/**
 * This Controller is having the Vendor related functionalities. This
 * Controller will call the vendorService in which the implementations are
 * done.
 * 
 * @API It has a method which will get the list of Vendors.
 * @author Raghib,Raghu
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/vendors")
@Slf4j
public class VendorController {


	/**
	 * This will inject all the implementations in the vendorService.
	 */
	
	@Autowired
	VendorService vendorService;
	
	/**
	 * @author Raghib
	 * 
	 *         this API is used to get the List of Vendors.
	 *         
	 * @return list of Vendors.
	 * 
	 */

	@GetMapping
	public ResponseEntity<List<Vendor>> getVendors() {
		log.info("Calling getVendors() method from VendorController");
		return ResponseEntity.ok().body(vendorService.getAllVendors());
	}
/**
 * 
 * @param loginRequestDto is argument to the authenticateVendor() method, this is used to check the authentication of vendors
 * @return
 * @throws NotFoundException
 */

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

	/**
	 * 
	 * @param registerVendorRequestDto is argument to the registerVnedor() method, this is used to register the  vendors
	 * @return
	 */
	@PostMapping
	public ResponseEntity<RegisterVendorResponseDto> registerVnedor(
			@RequestBody RegisterVendorRequestDto registerVendorRequestDto) {
		log.info("Starting registerVnedor() method ,inside VendorController");
		RegisterVendorResponseDto registerVendorResponseDto =  vendorService.registerVendor(registerVendorRequestDto);
		registerVendorResponseDto.setMessage("vendor registered successfully");
		registerVendorResponseDto.setStatusCode(HttpStatus.ACCEPTED.value());
		return ResponseEntity.ok().body(registerVendorResponseDto);

	}
}
