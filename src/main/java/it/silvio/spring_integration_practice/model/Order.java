package it.silvio.spring_integration_practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {

    private String id;
    private String product;
    private int quantity;
    private double price;
}
