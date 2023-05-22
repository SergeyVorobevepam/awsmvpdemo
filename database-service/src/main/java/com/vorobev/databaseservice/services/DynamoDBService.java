package com.vorobev.databaseservice.services;

import com.vorobev.databaseservice.entities.Order;
import com.vorobev.databaseservice.repository.OrderRepository;
import com.vorobev.databaseservice.services.interfaces.IDynamoDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DynamoDBService implements IDynamoDBService {

    private final OrderRepository orderRepository;

    @Override
    public Order getOrder(String orderId) {
        return orderRepository.getOrder(orderId);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.saveOrder(order);
    }

    @Override
    public String updateOrder(String productid, Order order) {
        return updateOrder(productid, order);
    }

    @Override
    public String deleteOrder(String productId) {
        return orderRepository.deleteOrder(productId);
    }
}
