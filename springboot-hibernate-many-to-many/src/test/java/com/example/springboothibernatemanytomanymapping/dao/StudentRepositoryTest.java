package com.example.springboothibernatemanytomanymapping.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboothibernatemanytomanymapping.entity.Course;
import com.example.springboothibernatemanytomanymapping.entity.Student;
@SpringBootTest
class StudentRepositoryTest {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentRepositoryTest.class);

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EntityManager em;

	@Test
	void findStudentById() {
		Student findStudentById = studentRepository.findStudentById(20001);
		assertEquals("Ranga", findStudentById.getName(), "Passed");
		
	}
	
	

	@Test
	@Transactional
	void retrieveCourseOfStudent() {
		Student student = studentRepository.findStudentById(20001);
		LOGGER.info("Student --> {} ",student);
		//mandatory to use @Transactional as here its lazy fetching
		LOGGER.info("Student Course  --> {} ",student.getCourses());
	}

}
