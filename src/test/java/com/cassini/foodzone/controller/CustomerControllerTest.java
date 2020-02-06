package com.cassini.foodzone.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;
import com.cassini.foodzone.dto.RegistrationDto;
import com.cassini.foodzone.dto.ResponseDto;
import com.cassini.foodzone.exception.NotFoundException;
import com.cassini.foodzone.service.CustomerService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerService customerService;

	@Test
	public void testRegistration() {
		RegistrationDto registrationDto = new RegistrationDto();
		Mockito.when(customerService.registration(Mockito.any())).thenReturn(new ResponseDto());
		Integer actual = customerController.registration(registrationDto).getStatusCode();
		Integer expected = 200;
		assertEquals(expected, actual);
	}

	@Test(expected = NotFoundException.class)
	public void testAuthenticateCustomerEmailNotFound() throws NotFoundException {
		LoginRequestDto loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmail("");
		customerController.authenticateCustomer(loginRequestDto);
	}

	@Test(expected = NotFoundException.class)
	public void testAuthenticateCustomerPasswordNotFound() throws NotFoundException {
		LoginRequestDto loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmail("test");
		loginRequestDto.setPassword("");
		customerController.authenticateCustomer(loginRequestDto);
	}

	@Test
	public void testAuthenticateCustomerSuccess() throws NotFoundException {
		LoginRequestDto loginRequestDto = new LoginRequestDto();
		loginRequestDto.setEmail("test");
		loginRequestDto.setPassword("test");
		Mockito.when(customerService.authenticateCustomer(Mockito.any())).thenReturn(new LoginResponseDto());
		Integer actual = customerController.authenticateCustomer(loginRequestDto).getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}

}
