package it.silvio.spring_integration_practice;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import it.silvio.spring_integration_practice.model.Order;

@MessagingGateway
public interface OrderGateway {
    
    @Gateway(requestChannel = "orderChannel")
    void placeOrder(Order order);
}
