package com.example.springboothibernatemanytomanymapping.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboothibernatemanytomanymapping.entity.Course;
import com.example.springboothibernatemanytomanymapping.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRepository.class);

	@Autowired
//	@PersistenceContext
	private EntityManager em;
	
	public Course findCourseById(int id) {
		return em.find(Course.class, id);
	}
	
	public void deleteCourseById(int id) {
		Course findById = em.find(Course.class, id);
		em.remove(findById);
	}
	
	public Course saveOrUpdate(Course course) {
		if(course.getId()==null) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
	}
	
	public void addReviewsForCourseHardCoded() {	
		//get course 10003
		Course course = em.find(Course.class, 10003);
		LOGGER.info("Course reviews --> {}",course.getReviews());
		//add 2 reviews
		Review review1 = new Review("4","Awesome course");
		Review review2 = new Review("5","Hats of to you");
		course.addReview(review1);
		course.addReview(review2);
		//since review is the owning side we need set course in review
		review1.setCourse(course);
		review2.setCourse(course);
		// save to db
		em.persist(review1);
		em.persist(review2);

	}
	
	public void addReviewsForCourse(Integer course_id, List<Review> reviews) {
		// get course 10003
		Course course = em.find(Course.class, course_id);
		LOGGER.info("Course reviews --> {}", course.getReviews());
		for (Review review : reviews) {
			// add review
			course.addReview(review);
			// since review is the owning side we need set course in review
			review.setCourse(course);
			// save to db
			em.persist(review);
		}
	}
	
}
