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
        String responseMessage = "Ordine ricevuto e in elaborazione";
        String errorMessage = "Errore nel riconoscimento della priorità dell'ordine";

        switch (order.getPriority()) {
            case HIGH:
                orderGateway.placeHighPriorityOrder(order);
                break;
            case MEDIUM:
                orderGateway.placeMediumPriorityOrder(order);
                break;
            default:
                return errorMessage;
        }
        return responseMessage;
    }

}
