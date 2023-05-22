package com.vorobev.generalservice.entities;

import lombok.Data;

@Data
public class Order {
    private String productName;
    private DeliveryAddress deliveryAddress;
}
