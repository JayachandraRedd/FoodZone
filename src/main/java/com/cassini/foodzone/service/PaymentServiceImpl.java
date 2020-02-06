package com.cassini.foodzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.foodzone.entity.Payment;
import com.cassini.foodzone.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	/**
	 * This method is used to get list of paymodes.
	 */
	@Override
	public List<Payment> getPaymentMode() {
		log.info("starting getPaymentMode method , inside PaymentServiceImpl");

		return paymentRepository.findAll();
	}


}
