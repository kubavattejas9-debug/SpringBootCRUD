package org.example;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

	private final PaymentService paymentservice;

	public OrderService(PaymentService paymentservice) {
		this.paymentservice = paymentservice;
	}

	public void PlaceOrder() {
		
		paymentservice.pay();
		System.out.println("Order Placed Successfully!");

	}
}
