package com.example.demo.dao;

public interface DSLResolver {
	String getResolverKeyword();
    Object resolveValue(String keyword);

}
