package com.vorobev.databaseservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vorobev.databaseservice.entities.Order;
import com.vorobev.databaseservice.exceptions.DbParsingException;
import com.vorobev.databaseservice.services.interfaces.IDynamoDBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DbSqsListener {

    private static final String RESPONSE_MESSAGE = "Message payload is not valid";

    private final ObjectMapper objectMapper;
    private final IDynamoDBService dynamoDBService;

    @SqsListener(value = "db-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receive(String message){
        Order order = null;
        try {
            order = objectMapper.readValue(message, Order.class);
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_MESSAGE, e);
            throw new DbParsingException(RESPONSE_MESSAGE);
        }

        dynamoDBService.saveOrder(order);
    }
}
