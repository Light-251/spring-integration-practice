package it.silvio.spring_integration_practice.model;

import it.silvio.spring_integration_practice.enums.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    private String id;
    private String product;
    private int quantity;
    private double price;
    private PriorityEnum priority;

    public Order() {
        this.priority = PriorityEnum.MEDIUM;
    }

}
