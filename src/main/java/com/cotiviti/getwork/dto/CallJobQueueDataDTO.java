package com.cotiviti.getwork.dto;

import java.util.List;

import com.cotiviti.getwork.model.CaseReviewReason;
import com.cotiviti.getwork.model.ClientEligibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CallJobQueueDataDTO {
	private long caseSeq;
	private String clientName;
	private String termDte;
	private List<CaseReviewReason> caseReviewReason;
	private List<ClientEligibility> clientEligibility;
	private String caseMember;
}
