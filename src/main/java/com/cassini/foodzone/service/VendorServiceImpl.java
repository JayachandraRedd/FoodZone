package com.cassini.foodzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.foodzone.entity.Vendor;
import com.cassini.foodzone.repository.VendorRepository;

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

}
