package com.cotiviti.getwork.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cotiviti.getwork.model.CallJobQueueData;

@Service
public class WorkApiClient {

	private final RestTemplate restTemplate;

	@Value("${api.work.url}")
	private String apiUrl; // Injecting the API URL from application.yml

	public WorkApiClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public CallJobQueueData fetchWorkData() {
		return restTemplate.getForObject(apiUrl, CallJobQueueData.class);
	}
}
