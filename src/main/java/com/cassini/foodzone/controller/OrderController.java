package com.cassini.foodzone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.foodzone.dto.OrderRequestDto;
import com.cassini.foodzone.dto.OrderResponseDto;
import com.cassini.foodzone.entity.CustomerOrder;
import com.cassini.foodzone.repository.CustomerOrderRepository;
import com.cassini.foodzone.service.CustomerOrderService;

import lombok.extern.slf4j.Slf4j;

/**
 * The LocationController program implements an application flightbooking
 * 
 * @author Amala
 * @version 1.0
 * @since 2020-02-04
 *
 */
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {
	@Autowired
	CustomerOrderService customerOrderService;
	@Autowired
	CustomerOrderRepository customerOrderRepository;

	@GetMapping
	public ResponseEntity<List<CustomerOrder>> getOrdersByCustomerId(Integer customerId) {
		return ResponseEntity.ok().body(customerOrderService.getOrdersByCustomerId(customerId));
	}

	@PostMapping
	public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
		return ResponseEntity.ok().body(customerOrderService.placeOrder(orderRequestDto));
	}
	
}
