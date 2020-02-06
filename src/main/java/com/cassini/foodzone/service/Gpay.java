package com.cassini.foodzone.service;

import org.springframework.stereotype.Service;

@Service("Gpay")
public class Gpay implements PaymentRegisteryService {

	@Override
	public String payment(String payMode) {
		return "payment done through Gapy";
	}

}
