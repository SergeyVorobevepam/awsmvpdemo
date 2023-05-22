package com.vorobev.databaseservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "custom.dynamodb")
@Data
@Component
public class DynamoDBProperties {
    private String endpoint;
    private String region;
}
