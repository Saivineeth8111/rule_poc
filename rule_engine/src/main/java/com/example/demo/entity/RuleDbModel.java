package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rules")
@IdClass(RuleDbModel.IdClass.class)
public class RuleDbModel {
	@Id
	@Column(name = "rule_namespace")
	private String ruleNamespace;

	@Id
	@Column(name = "rule_id")
	private String ruleId;

	@Column(name = "condition")
	private String condition;

	@Column(name = "action")
	private String action;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "description")
	private String description;

	@Data
	static class IdClass implements Serializable {
		private String ruleNamespace;
		private String ruleId;
	}
}
