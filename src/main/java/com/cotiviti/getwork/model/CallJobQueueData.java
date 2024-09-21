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
public class CallJobQueueData {
    private long caseSeq;
    private String clientName;
    private String termDte;
    private List<CaseReviewReason> caseReviewReason;
    private List<ClientEligibility> clientEligibility;
    private List<CaseMember> caseMember;
}
