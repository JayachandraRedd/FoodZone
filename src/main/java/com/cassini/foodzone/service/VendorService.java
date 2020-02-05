package com.cassini.foodzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cassini.foodzone.entity.Vendor;
import com.cassini.foodzone.repository.VendorRepository;

public interface VendorService {

	public List<Vendor> getAllVendors();

}
