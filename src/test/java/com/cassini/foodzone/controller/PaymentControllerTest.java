package com.cassini.foodzone.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.foodzone.service.PaymentRegistery;
import com.cassini.foodzone.service.PaymentService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PaymentControllerTest {
	
	@InjectMocks
	PaymentController paymentController;
	
	@Mock
	PaymentService paymentService;
	
	@Mock
	PaymentRegistery paymentRegistery;
	
	@Test
	public void testGetAllPaymentModeSuccess() {
		Mockito.when(paymentService.getPaymentMode()).thenReturn(new ArrayList<>());
		Integer actual = paymentController.getAllPaymentMode().getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}
	

}
