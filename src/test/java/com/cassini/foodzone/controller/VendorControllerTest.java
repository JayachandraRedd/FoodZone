package com.cassini.foodzone.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.foodzone.service.VendorService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class VendorControllerTest {
	
	@InjectMocks
	VendorController vendorController;

	@Mock
	VendorService vendorService;

}
