package com.tech.order.service.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.tech.order.service.api.common.Payment;
import com.tech.order.service.api.common.TransactionRequest;
import com.tech.order.service.api.common.TransactionResponse;
import com.tech.order.service.api.entity.Order;
import com.tech.order.service.api.repo.OrderRepo;

@Service
public class OrderService {
	
	
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		Order order = transactionRequest.getOrder();
		Payment payment = transactionRequest.getPayment();
		orderRepo.save(order);
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		Payment  paymentResponse = restTemplate.postForObject(ENDPOINT_URL, payment, Payment.class);
		String status = paymentResponse.getPaymentStatus().equals("success") ? " Payment done and order placed" : "Order failed";
		return new TransactionResponse(order, paymentResponse.getAmount(), status, paymentResponse.getTxnId());
	}

}
