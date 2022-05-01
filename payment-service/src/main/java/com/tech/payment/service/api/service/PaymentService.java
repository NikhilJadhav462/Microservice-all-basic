package com.tech.payment.service.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.payment.service.api.entity.Payment;
import com.tech.payment.service.api.repo.PaymentRepo;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepo paymentRepo;

	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTxnId(UUID.randomUUID().toString());
		return paymentRepo.save(payment);
	}
	
	private String paymentProcessing() {
		return new Random().nextBoolean() ? "success" :"false";
	}


}
