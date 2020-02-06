package com.cassini.foodzone.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.foodzone.dto.GetOrderRequestDto;
import com.cassini.foodzone.dto.OrderRequestDto;
import com.cassini.foodzone.dto.OrderResponseDto;
import com.cassini.foodzone.entity.Customer;
import com.cassini.foodzone.entity.CustomerOrder;
import com.cassini.foodzone.entity.Recipe;
import com.cassini.foodzone.entity.Vendor;
import com.cassini.foodzone.repository.CustomerOrderRepository;
import com.cassini.foodzone.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	CustomerOrderRepository customerOrderRepository;

	/**
	 * This method is used to get list of orders
	 */

	@Autowired
	RecipeRepository recipeRepository;

	@Override
	public List<CustomerOrder> getOrders(GetOrderRequestDto getOrderRequestDto) {
		log.info("starting getOrders method , inside CustomerOrderServiceImpl");
		Customer customer = new Customer();
		if (getOrderRequestDto.getCustomerId() != null) {
			customer.setCustomerId(getOrderRequestDto.getCustomerId());
			return customerOrderRepository.findByCustomer(customer);
		} else {
			Vendor vendor = new Vendor();
			vendor.setVendorId(getOrderRequestDto.getVendorId());
			return customerOrderRepository.findByVendorAndOrderStatus(vendor, getOrderRequestDto.getStatus());
		}

	}

	/**
	 * This method is used to place orders
	 */
	@Override
	public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
		log.info("starting placeOrder method , inside CustomerOrderServiceImpl");
		Customer customer = new Customer();
		customer.setCustomerId(orderRequestDto.getCustomerId());
		List<Recipe> recipes = new ArrayList<>();
		orderRequestDto.getRecipes().forEach(recipeId -> {
			Recipe recipe = new Recipe();
			recipe.setRecipeId(recipeId);
			recipes.add(recipe);
		});
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setDate(LocalDate.now());
		customerOrder.setOrderStatus("pending");
		customerOrder.setCustomer(customer);
		customerOrder.setRecipes(recipes);
		Vendor vendor = new Vendor();
		vendor.setVendorId(
				recipeRepository.findById(orderRequestDto.getRecipes().get(0)).get().getVendor().getVendorId());
		customerOrder.setVendor(vendor);
		customerOrderRepository.save(customerOrder);
		OrderResponseDto orderResponseDto = new OrderResponseDto();
		orderResponseDto.setOrderId(customerOrder.getOrderId());
		return orderResponseDto;
	}

}
