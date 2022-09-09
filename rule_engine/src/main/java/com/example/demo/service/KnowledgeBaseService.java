package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.RuleNamespace;
import com.example.demo.dao.RulesRepository;
import com.example.demo.dto.Rule;
import com.example.demo.entity.RuleDbModel;
import com.google.common.base.Enums;

@Service
public class KnowledgeBaseService {
	@Autowired
	private RulesRepository rulesRepository;

	public List<Rule> getAllRules() {
		return rulesRepository.findAll().stream().map(ruleDbModel -> mapFromDbModel(ruleDbModel))
				.collect(Collectors.toList());
	}

	public List<Rule> getAllRuleByNamespace(String ruleNamespace) {
		return rulesRepository.findByRuleNamespace(ruleNamespace).stream()
				.map(ruleDbModel -> mapFromDbModel(ruleDbModel)).collect(Collectors.toList());
	}

	private Rule mapFromDbModel(RuleDbModel ruleDbModel) {
		RuleNamespace namespace = Enums.getIfPresent(RuleNamespace.class, ruleDbModel.getRuleNamespace().toUpperCase())
				.or(RuleNamespace.DEFAULT);
		return Rule.builder().ruleNamespace(namespace).ruleId(ruleDbModel.getRuleId())
				.condition(ruleDbModel.getCondition()).action(ruleDbModel.getAction())
				.description(ruleDbModel.getDescription()).priority(ruleDbModel.getPriority()).build();
	}
}
