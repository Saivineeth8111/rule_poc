package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {
	String firstName;
	String lastName;
	Integer age;
	Long accountNumber;
	Double monthlySalary;
	String bank;
	Double creditScore;
	Double requestedLoanAmount;

}
