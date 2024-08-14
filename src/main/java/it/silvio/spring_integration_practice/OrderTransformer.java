package it.silvio.spring_integration_practice;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import it.silvio.spring_integration_practice.model.Order;

@Component
public class OrderTransformer {

    @Transformer(inputChannel = "orderChannel", outputChannel = "discountedOrderChannel")
    public Order transform(Order order) {
        order.setPrice(order.getPrice() * 0.9);
        return order;
    }

}
