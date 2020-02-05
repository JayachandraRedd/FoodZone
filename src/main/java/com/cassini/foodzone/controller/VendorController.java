package com.cassini.foodzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.foodzone.entity.Recipe;
import com.cassini.foodzone.entity.Vendor;
import com.cassini.foodzone.service.RecipeService;
import com.cassini.foodzone.service.VendorService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/vendors")
@Slf4j
public class VendorController {

	@Autowired
	VendorService vendorService;

	@GetMapping
	public ResponseEntity<List<Vendor>> getVendors() {
		log.info("Calling getVendors() method from VendorController");
		return ResponseEntity.ok().body(vendorService.getAllVendors());
	}

}
