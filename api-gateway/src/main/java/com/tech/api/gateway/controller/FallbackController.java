package com.tech.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	
	@RequestMapping("/orderFallback")
	public Mono<String> orderServiceFallback(){
		return Mono.just("Order service is taking too long or its down please try again later");
	}
	
	@RequestMapping("/paymentFallback")
	public Mono<String> paymentServiceFallBack(){
		return Mono.just("Payment service is taking too long or its down please try again later");
	}

}
