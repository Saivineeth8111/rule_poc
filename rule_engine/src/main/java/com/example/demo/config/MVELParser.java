package com.example.demo.config;

import java.util.Map;

import org.mvel2.MVEL;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class MVELParser {
	public boolean parseMvelExpression(String expression, Map<String, Object> inputObjects) {
		try {
			System.out.println(expression);
			System.out.println(inputObjects);
			return MVEL.evalToBoolean(expression, inputObjects);
		} catch (Exception e) {
			log.error("Can not parse Mvel Expression : {} Error: {}", expression, e.getMessage());
		}
		return false;
	}
}
