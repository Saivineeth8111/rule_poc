package com.example.demo.service;

//import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.demo.dto.User;
import com.example.demo.config.RuleNamespace;
import com.example.demo.dto.Loan;

//@Slf4j
@Service

public class LoanInference extends InferenceEngine<User, Loan> {

	@Override
	protected RuleNamespace getRuleNamespace() {
		return RuleNamespace.LOAN;
	}

	@Override
	protected Loan initializeOutputResult() {
		return Loan.builder().build();
	}

}
