package com.example.springboothibernateinheritancemappedsuperclass.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries(value = {
//		@NamedQuery(name="find_all_employees", query = "select e from Employee e")
		@NamedQuery(name="find_all_part_time_employees", query = "select e from PartTimeEmployee e"),
		@NamedQuery(name="find_all_full_time_employees", query = "select e from FullTimeEmployee e")
})
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
public abstract class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String name;
	
	public Employee() {
	}
	
	public Employee(String name) {
		this.name = name;
	}

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
