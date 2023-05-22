package com.vorobev.databaseservice.services.interfaces;

import com.vorobev.databaseservice.entities.Order;

public interface IDynamoDBService {
    Order getOrder(String orderId);

    Order saveOrder(Order order);

    String updateOrder(String productid, Order order);

    String deleteOrder(String productId);
}
