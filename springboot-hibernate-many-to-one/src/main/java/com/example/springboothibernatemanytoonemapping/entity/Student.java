package com.example.springboothibernatemanytoonemapping.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String name;
	//student is owning side of relationship
	@OneToOne(fetch = FetchType.LAZY)
	//@OneToOne
	private Passport passport;
	
	protected Student() {	
	}
	public Student(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Student(String name) {
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
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
		return String.format("Student [id=%s, name=%s]", id, name);
	}


}