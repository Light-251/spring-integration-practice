package it.silvio.spring_integration_practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.silvio.spring_integration_practice.model.Order;

@RestController
public class OrderController {

    @Autowired
    private OrderGateway orderGateway;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {
        orderGateway.placeOrder(order);
        return "Ordine ricevuto e in elaborazione";
    }
    
}
