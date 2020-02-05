package com.cassini.foodzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.foodzone.dto.CustomerOrderResponceDto;
import com.cassini.foodzone.entity.Customer;
import com.cassini.foodzone.entity.CustomerOrder;
import com.cassini.foodzone.repository.CustomerOrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerOrderServiceImpl implements CustomerOrderService {
	@Autowired
	CustomerOrderRepository customerOrderRepository;

	@Override
	public List<CustomerOrder> getOrdersByCustomerId(Integer customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		return customerOrderRepository.findByCustomer(customer);
	}


	
	 
}
