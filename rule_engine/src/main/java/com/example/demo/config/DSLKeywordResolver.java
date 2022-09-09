package com.example.demo.config;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DSLResolver;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@NoArgsConstructor

public class DSLKeywordResolver {
	Map<String, DSLResolver> dslKList;

	@Autowired
	public DSLKeywordResolver(List<DSLResolver> resolverList) {
		dslKList = resolverList.stream()
				.collect(Collectors.toMap(DSLResolver::getResolverKeyword, Function.identity()));
	}

	public Map<String, DSLResolver> getDslKeywordResolverList() {
		return dslKList;
	}

	public Optional<DSLResolver> getResolver(String keyword) {
		return Optional.ofNullable(dslKList.get(keyword));
	}

}
