package com.example.springboothibernatemanytomanymapping.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String number;
	
	// this will make student as owning side of relationship
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")  
	// this will make student and passport both as owning side of relationship
	//@OneToOne(fetch = FetchType.LAZY)
	private Student student;
	
	protected Passport() {	
	}
	public Passport(Integer id, String number) {
		this.id = id;
		this.number = number;
	}
	public Passport(String number) {
		this.number = number;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return String.format("Passport [id=%s, number=%s]", id, number);
	}


}