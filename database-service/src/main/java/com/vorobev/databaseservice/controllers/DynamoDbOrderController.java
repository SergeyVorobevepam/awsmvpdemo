package com.vorobev.databaseservice.controllers;

import com.vorobev.databaseservice.entities.Order;
import com.vorobev.databaseservice.services.DynamoDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/databaseservice")
public class DynamoDbOrderController {

    private final DynamoDBService dynamoDBService;

    @PostMapping("/order")
    public Order saveOrder(@RequestBody Order order) {
        return dynamoDBService.saveOrder(order);
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") String orderId) {
        return dynamoDBService.getOrder(orderId);
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable("id") String orderId) {
        return dynamoDBService.deleteOrder(orderId);
    }

    @PutMapping("/order/{id}")
    public String updateOrder(@PathVariable("id") String orderId, @RequestBody Order order) {
        return dynamoDBService.updateOrder(orderId, order);
    }
}
