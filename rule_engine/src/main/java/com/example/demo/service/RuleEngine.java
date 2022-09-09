package com.example.demo.service;

import java.util.List;

//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Rule;

//@Slf4j

@Service
public class RuleEngine {
	@Autowired(required = true)
	private RuleService Service;

	public Object run(InferenceEngine inferenceEngine, Object inputData) {

		String ruleNamespace = inferenceEngine.getRuleNamespace().toString();
		// TODO: Here for each call, we are fetching all rules from db. It should be
		// cache.
		List<Rule> allRulesByNamespace = Service.getAllRuleByNamespace(ruleNamespace);
		Object result = inferenceEngine.run(allRulesByNamespace, inputData);
		return result;
		// return ruleNamespace;
	}
}
