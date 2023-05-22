package com.vorobev.generalservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vorobev.generalservice.entities.Order;
import com.vorobev.generalservice.exceptions.DbParsingException;
import com.vorobev.generalservice.services.interfaces.IDynanamoDbQueueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class DynanamoDbQueueService implements IDynanamoDbQueueService {

    private static final String RESPONSE_MESSAGE = "Request is not valid!";
    private static final String ERROR_LOG_MESSAGE = "Cannot parse to JSON object!";

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String sqsEndpoint;

    private final ObjectMapper objectMapper;

    @Override
    public void addorder(Order order) {
        String message = null;
        try {
            message = objectMapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            log.error(ERROR_LOG_MESSAGE, e);
            throw new DbParsingException(RESPONSE_MESSAGE);
        }

        Message payload = MessageBuilder
                .withPayload(message)
                .setHeader("sender", "Sergey")
                .build();

        queueMessagingTemplate.send(sqsEndpoint, payload);
    }
}
