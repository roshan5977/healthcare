package com.cotiviti.getwork.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberAddress {
	private String address1;
	private String city;
	private String stateCd;
}
