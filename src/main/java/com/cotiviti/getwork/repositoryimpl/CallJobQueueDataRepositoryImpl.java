package com.cotiviti.getwork.repositoryimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cotiviti.getwork.dto.CallJobQueueDataDTO;
import com.cotiviti.getwork.repository.CallJobQueueDataRepository;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

@Repository
public class CallJobQueueDataRepositoryImpl implements CallJobQueueDataRepository {

	@Autowired
	private DynamoDbClient dynamoDbClient;

	public CallJobQueueDataRepositoryImpl(DynamoDbClient dynamoDbClient) {
		this.dynamoDbClient = dynamoDbClient;
	}

	@Override
	public void save(CallJobQueueDataDTO callJobQueueDataDTO) {
		// Create the request to put data into DynamoDB
		Map<String, AttributeValue> itemValues = new HashMap<>();

		itemValues.put("caseSeq", AttributeValue.builder().n(String.valueOf(callJobQueueDataDTO.getCaseSeq())).build());
		itemValues.put("clientName", AttributeValue.builder().s(callJobQueueDataDTO.getClientName()).build());
		itemValues.put("termDte", AttributeValue.builder().s(callJobQueueDataDTO.getTermDte()).build());
		// You would need to serialize complex fields like lists into a string or
		// another suitable format
		itemValues.put("caseReviewReason",
				AttributeValue.builder().s(callJobQueueDataDTO.getCaseReviewReason().toString()).build());
		itemValues.put("clientEligibility",
				AttributeValue.builder().s(callJobQueueDataDTO.getClientEligibility().toString()).build());
		itemValues.put("caseMember", AttributeValue.builder().s(callJobQueueDataDTO.getCaseMember()).build());

		PutItemRequest request = PutItemRequest.builder().tableName("CallJobQueueDataTable") // Your DynamoDB table name
				.item(itemValues).build();

		// Put the item into DynamoDB
		dynamoDbClient.putItem(request);
	}
}
