package com.example.springboothibernatemanytomanymapping.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboothibernatemanytomanymapping.dao.CourseRepository;
import com.example.springboothibernatemanytomanymapping.entity.Course;
@SpringBootTest
class CourseRepositoryTest {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryTest.class);

	@Autowired
	private CourseRepository courseRepository;

	@Test
	void findCourseById() {
		Course findCourseById = courseRepository.findCourseById(10001);
		assertEquals("JPA in 10 Steps", findCourseById.getName(), "Passed");
		
	}
	
	@Test
	void deleteCourseById() {
		courseRepository.deleteCourseById(10003);
		Course findCourseById = courseRepository.findCourseById(10003);
		assertNull(findCourseById);
		
	}
	
	@Test
	void saveCourse() {
		String name = "Microservice in 15 steps";
		Course course= new Course(name);
		 Course saveOrUpdate = courseRepository.saveOrUpdate(course);
		assertEquals(name, saveOrUpdate.getName(), "Passed");
		
	}
	
	@Test
	void updateCourse() {
		String name = "Hibernate in 10 Steps";
		String updatedName = "Hibernate in 10 Steps Updated";
		Course course = courseRepository.findCourseById(10002);
		assertEquals(name, course.getName(), "Passed");
		course.setName(updatedName);
		 Course updateCourse = courseRepository.saveOrUpdate(course);
		assertEquals(updatedName, updateCourse.getName(), "Passed");
		
	}

//	Easy to remember
//	***ToOne is always Eager Fetching
//	***ToMANY us always Lazy fetching
	@Test
	@Transactional
	void retrieveReviewForCourse() {
		Course course = courseRepository.findCourseById(10001);
		LOGGER.info("Course Reviews --> {} ",course.getReviews());
		//mandatory to use @Transactional as here its lazy fetching
	}
	
	@Test
	@Transactional
	void retrieveStudentForCourse() {
		Course course = courseRepository.findCourseById(10001);
		LOGGER.info("Course  --> {} ",course);
		LOGGER.info("Course Students --> {} ",course.getStudents());
		//mandatory to use @Transactional as here its lazy fetching
	}
	

}
