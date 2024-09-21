package com.cotiviti.getwork.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseMember {
	private long caseMemberSeq;
	private String dob;
	private String firstNm;
	private String middleNm;	
	private String lastName;
	private List<MemberAddress> memberAddresses;
	private List<MemberAddressExtra> memberAddressesExtra;
	private String ssn; 
	private boolean medicareEntitlementDisabilityInd;
	private String medicareEntitlementAgeIndSuspected;
	private String relationshipCd;
	private String planName;
	private String deathDte;
	private String gender;
	private String suffix;
	private String medicareIdSuffix;
	private String medicareIdPrefix;
}
