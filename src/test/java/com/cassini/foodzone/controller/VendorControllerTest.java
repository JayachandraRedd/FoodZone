package com.cassini.foodzone.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;
import com.cassini.foodzone.dto.RegisterVendorRequestDto;
import com.cassini.foodzone.dto.RegisterVendorResponseDto;
import com.cassini.foodzone.exception.NotFoundException;
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
	
	@Test(expected = NotFoundException.class)
	public void testAuthenticateVendorEmailNotFound() throws NotFoundException {
		LoginRequestDto loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmail("");
		vendorController.authenticateVendor(loginRequestDto);
	}

	@Test(expected = NotFoundException.class)
	public void testAuthenticateCustomerPasswordNotFound() throws NotFoundException {
		LoginRequestDto loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmail("test");
		loginRequestDto.setPassword("");
		vendorController.authenticateVendor(loginRequestDto);
	}

	@Test
	public void testAuthenticateCustomerSuccess() throws NotFoundException {
		LoginRequestDto loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmail("test");
		loginRequestDto.setPassword("test");
		Mockito.when(vendorService.authenticateVendor(Mockito.any())).thenReturn(new LoginResponseDto());
		Integer actual = vendorController.authenticateVendor(loginRequestDto).getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRegisterVnedor() {
		Mockito.when(vendorService.registerVendor(Mockito.any())).thenReturn(new RegisterVendorResponseDto());
		Integer actual = vendorController.registerVnedor(new RegisterVendorRequestDto()).getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}
}
