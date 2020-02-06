package com.cassini.foodzone.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.foodzone.dto.GetOrderRequestDto;
import com.cassini.foodzone.dto.OrderRequestDto;
import com.cassini.foodzone.dto.OrderResponseDto;
import com.cassini.foodzone.service.CustomerOrderService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderControllerTest {
	
	@InjectMocks
	OrderController orderController;

	@Mock
	CustomerOrderService customerOrderService;
	
	@Test
	public void testGetOrdersSuccess() {
		Mockito.when(customerOrderService.getOrders(Mockito.any())).thenReturn(new ArrayList<>());
		Integer actual = orderController.getOrders(new GetOrderRequestDto()).getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPlaceOrderSuccess() {
		Mockito.when(customerOrderService.placeOrder(Mockito.any())).thenReturn(new OrderResponseDto());
		Integer actual = orderController.placeOrder(new OrderRequestDto()).getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}

}
