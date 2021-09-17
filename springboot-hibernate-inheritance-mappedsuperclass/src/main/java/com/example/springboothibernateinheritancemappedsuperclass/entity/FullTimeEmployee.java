package com.example.springboothibernateinheritancemappedsuperclass.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

	private BigDecimal Salary;

	
	public FullTimeEmployee() {
	}

	public FullTimeEmployee(Integer id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public FullTimeEmployee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		Salary = salary;
	}

	public BigDecimal getSalary() {
		return Salary;
	}

	public void setSalary(BigDecimal salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return String.format(
				"FullTimeEmployee [Salary=%s, getId()=%s, getName()=%s]",
				Salary, getId(), getName());
	}
	
	
}
