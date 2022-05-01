package com.tech.order.service.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	private int paymentId;
	private String paymentStatus;
	private String txnId;
	private int orderId;
	private int amount;

}
