package com.tech.order.service.api.common;

import com.tech.order.service.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
	
	private Payment payment;
	private Order order;

}
