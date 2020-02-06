package com.cassini.foodzone.service;

import org.springframework.stereotype.Service;

@Service("PayTm")
public class PayTm implements PaymentRegisteryService {

	@Override
	public String payment(String payMode) {
		return "payment done through PayTm";
	}

}
