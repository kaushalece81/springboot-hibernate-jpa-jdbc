package com.example.springboothibernatemanytoonemapping.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String name;
	// one course has many reviews
	//Since course in non owning side of relationship hence we defined here
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();
	
	protected Course() {	
	}
	public Course(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Course(String name) {
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
	public List<Review> getReviews() {
		return reviews;
	}
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s]", id, name);
	}
}