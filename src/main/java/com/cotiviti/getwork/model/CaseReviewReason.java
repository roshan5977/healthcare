package com.cotiviti.getwork.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CaseReviewReason {
	private long reviewReasonId;
	private List<String> reviewReason;
}
