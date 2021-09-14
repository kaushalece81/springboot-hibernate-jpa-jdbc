package com.example.springboothibernateonetoonemapping.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String rating;
	
	private String description;
	
	protected Review() {
	}
	
	public Review(Integer id, String rating, String description) {
		this.id = id;
		this.rating = rating;
		this.description = description;
	}

	public Review(String rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Review [id=%s, rating=%s, description=%s]", id, rating, description);
	}

}