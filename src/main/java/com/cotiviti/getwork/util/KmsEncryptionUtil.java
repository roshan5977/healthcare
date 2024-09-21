package com.cotiviti.getwork.util;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.model.DecryptRequest;
import software.amazon.awssdk.services.kms.model.DecryptResponse;
import software.amazon.awssdk.services.kms.model.EncryptRequest;
import software.amazon.awssdk.services.kms.model.EncryptResponse;

@Component
public class KmsEncryptionUtil {

	private final KmsClient kmsClient;

	@Value("${amazon.kms.keyId}") // Load the KMS key from the application.yml
	private String kmsKeyId;

	public KmsEncryptionUtil(KmsClient kmsClient) {
		this.kmsClient = kmsClient;
	}

	// Encrypt the plaintext data
	public String encrypt(List plaintext) {
		String s = plaintext.toString();
		EncryptRequest encryptRequest = EncryptRequest.builder().keyId(kmsKeyId).plaintext(SdkBytes.fromUtf8String(s))
				.build();

		EncryptResponse encryptResponse = kmsClient.encrypt(encryptRequest);
		return Base64.getEncoder().encodeToString(encryptResponse.ciphertextBlob().asByteArray());
	}

	// Decrypt the ciphertext data
	public String decrypt(String ciphertext) {
		DecryptRequest decryptRequest = DecryptRequest.builder()
				.ciphertextBlob(SdkBytes.fromByteArray(Base64.getDecoder().decode(ciphertext))).build();

		DecryptResponse decryptResponse = kmsClient.decrypt(decryptRequest);
		return decryptResponse.plaintext().asUtf8String();
	}
}
