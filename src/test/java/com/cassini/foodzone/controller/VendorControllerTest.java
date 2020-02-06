package com.cassini.foodzone.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.foodzone.service.VendorService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class VendorControllerTest {
	
	@InjectMocks
	VendorController vendorController;

	@Mock
	VendorService vendorService;
	
	@Test
	public void testGetVendorsSuccess() {
		Mockito.when(vendorService.getAllVendors()).thenReturn(new ArrayList<>());
		Integer actual = vendorController.getVendors().getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}
	
//	@Test
//	public void testGetVendorsSuccess() {
//		Mockito.when(vendorService.getAllVendors()).thenReturn(new ArrayList<>());
//		Integer actual = vendorController.getVendors().getStatusCodeValue();
//		Integer expected = 200;
//		assertEquals(expected, actual);
//	}

}
