package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order= context.getBean(OrderService.class);
        order.PlaceOrder();
    }
}
