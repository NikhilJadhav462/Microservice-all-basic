package com.tech.order.service.api.common;

import com.tech.order.service.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	
	private Order order;
	private int amount;
	private String status;
	private String txnId;
	

}
