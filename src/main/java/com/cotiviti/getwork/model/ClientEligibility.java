package com.cotiviti.getwork.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientEligibility {
	private String medicareAcct5Digits;
	private String rre;
}
