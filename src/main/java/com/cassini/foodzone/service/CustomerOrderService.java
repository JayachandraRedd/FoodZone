package com.cassini.foodzone.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cassini.foodzone.entity.CustomerOrder;

public interface CustomerOrderService {

	List<CustomerOrder> getOrdersByCustomerId(Integer customerId);

}
