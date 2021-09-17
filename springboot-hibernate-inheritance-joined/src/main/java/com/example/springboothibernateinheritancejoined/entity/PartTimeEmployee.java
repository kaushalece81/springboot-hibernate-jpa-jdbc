package com.example.springboothibernateinheritancejoined.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal hourlyWage;

	
	public PartTimeEmployee() {
	}

	public PartTimeEmployee(Integer id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public PartTimeEmployee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(BigDecimal hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		return String.format(
				"PartTimeEmployee [hourlyWage=%s, getId()=%s, getName()=%s]",
				hourlyWage, getId(), getName());
	}

	
}
