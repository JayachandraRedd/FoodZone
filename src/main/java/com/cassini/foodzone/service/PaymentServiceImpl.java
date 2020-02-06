package com.cassini.foodzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.foodzone.entity.Payment;
import com.cassini.foodzone.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public List<Payment> getPaymentMode() {
		
		return paymentRepository.findAll();
	}


}
