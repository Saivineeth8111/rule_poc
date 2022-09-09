package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.config.RuleNamespace;
import com.example.demo.dto.InsuranceDetails;
import com.example.demo.dto.PolicyHolderDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InsuranceInferenceEngine extends InferenceEngine<PolicyHolderDetails, InsuranceDetails> {

	@Override
	protected RuleNamespace getRuleNamespace() {
		return RuleNamespace.INSURANCE;
	}

	@Override
	protected InsuranceDetails initializeOutputResult() {
		return InsuranceDetails.builder().build();
	}
}
