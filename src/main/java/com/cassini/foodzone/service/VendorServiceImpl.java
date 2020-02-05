package com.cassini.foodzone.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;
import com.cassini.foodzone.dto.RegisterVendorRequestDto;
import com.cassini.foodzone.dto.RegisterVendorResponseDto;
import com.cassini.foodzone.entity.Vendor;
import com.cassini.foodzone.exception.NotFoundException;
import com.cassini.foodzone.repository.VendorRepository;
import com.cassini.foodzone.util.Constant;
import com.cassini.foodzone.util.GeneratePassword;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Override

	public List<Vendor> getAllVendors() {
		
	log.info("Fetching All Vendors records from VendorRepository");
	return vendorRepository.findAll();
	}

	public LoginResponseDto authenticateVendor(LoginRequestDto loginRequestDto) throws NotFoundException {
		log.info("VendorServiceImpl authenticateVendor ---> autheticating vendor");
	Optional<Vendor> vendor = vendorRepository.findByEmailAndPassword(loginRequestDto.getEmail(),
			loginRequestDto.getPassword());
	if (vendor.isPresent()) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		BeanUtils.copyProperties(vendor.get(), loginResponseDto);
		loginResponseDto.setId(vendor.get().getVendorId());
		log.info("VendorServiceImpl authenticateVendor ---> vendor logged in");
		return loginResponseDto;
	} else {
		log.error("VendorServiceImpl authenticateVendor ---> NotFoundException occured ");
		throw new NotFoundException(Constant.VENDOR_NOT_FOUND);
	}
	}

	@Override
	public RegisterVendorResponseDto registerVendor(RegisterVendorRequestDto registerVendorRequestDto) {
		Vendor vendor = new Vendor();
		BeanUtils.copyProperties(registerVendorRequestDto, vendor);
		vendor.setPassword(new GeneratePassword().generatePasscode());
		vendorRepository.save(vendor);
		RegisterVendorResponseDto registerVendorResponseDto = new RegisterVendorResponseDto();
		registerVendorResponseDto.setPassword(vendor.getPassword());
		return registerVendorResponseDto;

	}

}
