package com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.dao.CourseRepository;
import com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.entity.Course;
@SpringBootTest
class CourseRepositoryTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryTest.class);
	@Autowired
	private CourseRepository courseRepository;

	@Test
	void testFindCourseById() {
		Course findCourseById = courseRepository.findCourseById(10001);
		assertEquals("JPA in 10 Steps", findCourseById.getName(), "Passed");
		
	}
	
	@Test
	void testDeleteCourseById() {
		courseRepository.deleteCourseById(10003);
		Course findCourseById = courseRepository.findCourseById(10003);
		assertNull(findCourseById);
		
	}
	
	@Test
	void testSaveCourse() {
		String name = "Microservice in 15 steps";
		Course course= new Course(name);
		 Course saveOrUpdate = courseRepository.saveOrUpdate(course);
		assertEquals(name, saveOrUpdate.getName(), "Passed");
		
	}
	
	@Test
	void testUpdateCourse() {
		String name = "Hibernate in 10 Steps";
		String updatedName = "Hibernate in 10 Steps Updated";
		Course course = courseRepository.findCourseById(10002);
		assertEquals(name, course.getName(), "Passed");
		course.setName(updatedName);
		 Course updateCourse = courseRepository.saveOrUpdate(course);
		assertEquals(updatedName, updateCourse.getName(), "Passed");
		
	}

}
