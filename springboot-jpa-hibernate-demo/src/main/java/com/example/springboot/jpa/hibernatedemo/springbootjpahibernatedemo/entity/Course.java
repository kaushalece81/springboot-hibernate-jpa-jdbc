package com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.entity;

import java.lang.annotation.Repeatable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
//@NamedQuery(name = "query_get_all_courses" , query = "Select c from Course c")
//@NamedQuery(name = "query_get_100_steps_courses" , query = "Select c from Course c where name like '%100 Steps%'")
//Note @NamedQuery is @Repeatable(NamedQueries.class).
@NamedQueries(value = {@NamedQuery(name = "query_get_all_courses" , query = "Select c from Course c"),
@NamedQuery(name = "query_get_100_steps_courses" , query = "Select c from Course c where name like '%100 Steps%'")})
public class Course {
	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	protected Course() {	
	}
	public Course(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Course(String name) {
		this.name = name;
	}
	
	public Course(Integer id, String name, LocalDateTime lastUpdatedDate, LocalDateTime createdDate) {
		this.id = id;
		this.name = name;
		this.lastUpdatedDate = lastUpdatedDate;
		this.createdDate = createdDate;
	}
	public Course(String name, LocalDateTime lastUpdatedDate, LocalDateTime createdDate) {
		this.name = name;
		this.lastUpdatedDate = lastUpdatedDate;
		this.createdDate = createdDate;
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
//	@Override
//	public String toString() {
//		return String.format("Course [id=%s, name=%s]", id, name);
//	}
	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s, lastUpdatedDate=%s, createdDate=%s]", id, name, lastUpdatedDate,
				createdDate);
	}
	
}
