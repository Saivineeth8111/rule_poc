package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.RuleNamespace;
import com.example.demo.dto.InsuranceDetails;
import com.example.demo.dto.Loan;
import com.example.demo.dto.PolicyHolderDetails;
import com.example.demo.dto.Rule;
import com.example.demo.dto.User;
import com.example.demo.service.InsuranceInferenceEngine;
import com.example.demo.service.LoanInference;
import com.example.demo.service.RuleEngine;
import com.example.demo.service.RuleService;
import com.google.common.base.Enums;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class RuleEngineController {
	@Autowired
	private RuleService Service;
	@Autowired
	private RuleEngine ruleEngine;
	@Autowired
	private LoanInference loanInferenceEngine;
	@Autowired
	private InsuranceInferenceEngine insuranceInferenceEngine;

	@GetMapping(value = "/get-all-rules")
	public List<Rule> getAllRules() {
		List<Rule> allRules = Service.getAllRules();
		return allRules;
	}

	@GetMapping(value = "/get-all-rules/{ruleNamespace}")
	public ResponseEntity<?> getRulesByNamespace(@PathVariable("ruleNamespace") String ruleNamespace) {
		RuleNamespace namespace = Enums.getIfPresent(RuleNamespace.class, ruleNamespace.toUpperCase())
				.or(RuleNamespace.DEFAULT);
		List<Rule> allRules = Service.getAllRuleByNamespace(namespace.toString());
		return ResponseEntity.ok(allRules);
	}

	@PostMapping(value = "/loan")
	public ResponseEntity<?> postUserLoanDetails(@RequestBody User user) {
		Loan result = (Loan) ruleEngine.run(loanInferenceEngine, user);
		return ResponseEntity.ok(result);
	}

	@PostMapping(value = "/insurance")
	public ResponseEntity<?> postCarLoanDetails(@RequestBody PolicyHolderDetails policyHolderDetails) {
		InsuranceDetails result = (InsuranceDetails) ruleEngine.run(insuranceInferenceEngine, policyHolderDetails);
		return ResponseEntity.ok(result);
	}
}