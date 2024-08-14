package it.silvio.spring_integration_practice;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import it.silvio.spring_integration_practice.model.Order;

@MessagingGateway
public interface OrderGateway {

    @Gateway(requestChannel = "highPriorityOrderChannel")
    void placeHighPriorityOrder(Order order);

    @Gateway(requestChannel = "mediumPriorityOrderChannel")
    void placeMediumPriorityOrder(Order order);

    @Gateway(requestChannel = "lowPriorityChannel")
    void placeLowPriorityOrder(Order order);
}
