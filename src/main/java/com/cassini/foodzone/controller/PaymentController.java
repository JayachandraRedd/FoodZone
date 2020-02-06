package com.cassini.foodzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.foodzone.entity.Payment;
import com.cassini.foodzone.service.PaymentRegistery;
import com.cassini.foodzone.service.PaymentService;
/**
 * The LocationController program implements an application flightbooking
 * 
 * @author Amala
 * @version 1.0
 * @since 2020-02-04
 *
 */

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	PaymentRegistery paymentRegistery;

	@GetMapping
	public ResponseEntity<List<Payment>> getAllPaymentMode() {
		log.info("starting getAllPaymentMode method , inside PaymentController");

		return ResponseEntity.ok().body(paymentService.getPaymentMode());
	}

	@GetMapping("/pay")
	public ResponseEntity<String> makePayment(@RequestParam String paymentMode) {
		log.info("starting makePayment method , inside PaymentController");
		String payment = paymentRegistery.getServiceBean(paymentMode)
				.payment(paymentMode);
		
		return ResponseEntity.ok().body("payment done through " + payment);
	}

}
