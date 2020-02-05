package com.cassini.foodzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.foodzone.entity.Payment;
import com.cassini.foodzone.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping
	public ResponseEntity<List<Payment>> getAllPaymentMode() {

		return ResponseEntity.ok().body(paymentService.getPaymentMode());
	}

	@PostMapping
	public ResponseEntity<String> makePayment(@RequestParam String paymentMode) {
		
		return ResponseEntity.ok().body("payment done through" + paymentMode);
	}

}
