package com.example.demo.dto;

import com.example.demo.config.RuleNamespace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Rule {
	RuleNamespace ruleNamespace;
	String ruleId;
	String condition;
	String action;
	Integer priority;
	String description;
}
