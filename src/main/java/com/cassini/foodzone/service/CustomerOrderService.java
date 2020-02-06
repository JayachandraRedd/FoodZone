package com.cassini.foodzone.service;

import java.util.List;

import com.cassini.foodzone.dto.GetOrderRequestDto;
import com.cassini.foodzone.dto.OrderRequestDto;
import com.cassini.foodzone.dto.OrderResponseDto;
import com.cassini.foodzone.entity.CustomerOrder;
import com.cassini.foodzone.exception.NotFoundException;

public interface CustomerOrderService {

	List<CustomerOrder> getOrders(GetOrderRequestDto getOrderRequestDto);
	
	OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws NotFoundException;

}
