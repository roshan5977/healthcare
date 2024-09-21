package com.cotiviti.getwork.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotiviti.getwork.client.WorkApiClient;
import com.cotiviti.getwork.dto.CallJobQueueDataDTO;
import com.cotiviti.getwork.model.CallJobQueueData;
import com.cotiviti.getwork.repository.CallJobQueueDataRepository;
import com.cotiviti.getwork.service.CallJobQueueDataService;
import com.cotiviti.getwork.util.KmsEncryptionUtil;

@Service
public class CallJobQueueDataServiceImpl implements CallJobQueueDataService {

	private final WorkApiClient workApiClient;
	private final CallJobQueueDataRepository callJobQueueDataRepository;
	private final KmsEncryptionUtil kmsEncryptionUtil;

	@Autowired
	public CallJobQueueDataServiceImpl(WorkApiClient workApiClient,
			CallJobQueueDataRepository callJobQueueDataRepository, KmsEncryptionUtil kmsEncryptionUtil) {
		this.workApiClient = workApiClient;
		this.callJobQueueDataRepository = callJobQueueDataRepository;
		this.kmsEncryptionUtil = kmsEncryptionUtil;
	}

	@Override
	public void processAndSaveWorkData() {
		// Step 1: Fetch data from external API
		CallJobQueueData workData = workApiClient.fetchWorkData();

		// Step 2: Encrypt the caseMember data
//		String encryptedCaseMember = kmsEncryptionUtil.encrypt(workData.getCaseMember());

		// Step 3: Map CallJobQueueData to CallJobQueueDataDTO
		CallJobQueueDataDTO callJobQueueDataDTO = mapToDTO(workData, "encryptedCaseMember");

		// Step 4: Save data into DynamoDB
		callJobQueueDataRepository.save(callJobQueueDataDTO);
	}

	private CallJobQueueDataDTO mapToDTO(CallJobQueueData workData, String encryptedCaseMember) {
		return CallJobQueueDataDTO.builder().caseSeq(workData.getCaseSeq()).clientName(workData.getClientName())
				.termDte(workData.getTermDte()).caseReviewReason(workData.getCaseReviewReason()) // Assuming a List
				.clientEligibility(workData.getClientEligibility()) // Assuming a List
				.caseMember(encryptedCaseMember).build();
	}
}
