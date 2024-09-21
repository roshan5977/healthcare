package com.cotiviti.getwork.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kms.KmsClient;

@Configuration
public class KmsConfig {

	@Value("${amazon.kms.region}") // Externalize the region to the properties file
	private String region;

	@Bean
	public KmsClient kmsClient() {
		return KmsClient.builder().region(Region.of(region)).build();
	}
}
