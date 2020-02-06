package com.cassini.foodzone.service;

import org.springframework.stereotype.Service;

@Service("PhonePe")
public class PhonePe implements PaymentRegisteryService {

	@Override
	public String payment(String payMode) {
		return "payment done through PhonePe";
	}

}
