package com.example.springboothibernatemanytomanymapping.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	//lets make student owning side so mappedBy in course entity
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	// If we do not give join table then table name has plural and one of column name is plural 
	//joinColumn STUDENT_ID
	//inverseJoinColumn COURSE_ID
	private List<Course> courses = new ArrayList<>();
	
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
	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	
	@Override
	public String toString() {
		return String.format("Student [id=%s, name=%s]", id, name);
	}


}