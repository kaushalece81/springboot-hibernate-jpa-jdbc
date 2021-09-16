package com.example.springboothibernatemanytoonemapping.dao;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboothibernatemanytoonemapping.entity.Review;

@Repository
@Transactional
public class ReviewRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewRepository.class);

	@Autowired
//	@PersistenceContext
	private EntityManager em;
	
	public Review findReviewById(int id) {
		return em.find(Review.class, id);
	}
	
	
}
