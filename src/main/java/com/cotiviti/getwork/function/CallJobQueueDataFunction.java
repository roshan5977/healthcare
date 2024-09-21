package com.cotiviti.getwork.function;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.cotiviti.getwork.service.CallJobQueueDataService;

@Component
public class CallJobQueueDataFunction {

	private final CallJobQueueDataService callJobQueueDataService;

	@Autowired
	public CallJobQueueDataFunction(CallJobQueueDataService callJobQueueDataService) {
		this.callJobQueueDataService = callJobQueueDataService;
	}

	// Supplier function to trigger the Lambda process
	@Bean
	public Supplier<String> callJobQueueDataHandler() {
		return () -> {
			try {
				callJobQueueDataService.processAndSaveWorkData();
				return "Success";
			} catch (Exception e) {
				return "Error: " + e.getMessage();
			}
		};
	}
}
