package com.cotiviti.getwork.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cotiviti.getwork.dto.CallJobQueueDataDTO;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;


public interface CallJobQueueDataRepository {

    void save(CallJobQueueDataDTO callJobQueueDataDTO);

}
 