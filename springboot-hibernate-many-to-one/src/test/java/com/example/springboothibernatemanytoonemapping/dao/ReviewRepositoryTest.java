package com.example.springboothibernatemanytoonemapping.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboothibernatemanytoonemapping.entity.Course;
import com.example.springboothibernatemanytoonemapping.entity.Review;
@SpringBootTest
class ReviewRepositoryTest {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewRepositoryTest.class);

	@Autowired
	private ReviewRepository reviewRepository;

	@Test
	void findCourseById() {
		Review review = reviewRepository.findReviewById(40001);
		LOGGER.info("Review--> {}", review);
		
	}
//	Easy to remember
//	***ToOne is always Eager Fetching
//	***ToMANY us always Lazy fetching
	@Test
	void retrieveCourseForReview() {
		Review review = reviewRepository.findReviewById(40001);
		LOGGER.info("From Review get Course--> {}", review.getCourse());
		//Here @Transactional not required as here its Eager fetching
		
	}
	

}
