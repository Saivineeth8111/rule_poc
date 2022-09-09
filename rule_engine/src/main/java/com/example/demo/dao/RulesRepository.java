package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RuleDbModel;

@Repository
public interface RulesRepository extends JpaRepository<RuleDbModel, Long> {
	List<RuleDbModel> findByRuleNamespace(String ruleNamespace);

	List<RuleDbModel> findAll();
}
