package com.vorobev.databaseservice.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.vorobev.databaseservice.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public Order getOrder(String orderId) {
        return dynamoDBMapper.load(Order.class, orderId);
    }

    public Order saveOrder(Order order) {
        dynamoDBMapper.save(order);
        return order;
    }

    public String updateOrder(String productid, Order order) {
        dynamoDBMapper.save(order,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("productid",
                                new ExpectedAttributeValue(new AttributeValue().withS(productid)))
        );
        return productid;
    }

    public String deleteOrder(String productId) {
        Order orderToDelete = dynamoDBMapper.load(Order.class, productId);
        dynamoDBMapper.delete(orderToDelete);
        return "Delete successful";
    }
}

