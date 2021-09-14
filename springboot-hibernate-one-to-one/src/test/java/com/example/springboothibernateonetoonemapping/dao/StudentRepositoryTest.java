package com.example.springboothibernateonetoonemapping.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboothibernateonetoonemapping.entity.Passport;
import com.example.springboothibernateonetoonemapping.entity.Student;
@SpringBootTest
class StudentRepositoryTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentRepositoryTest.class);

	@Autowired
	private EntityManager em;
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	@Transactional
	void retrieveStudentAndThenPassportDetailsFromStudent() {
		Student student= em.find(Student.class,20001);
		LOGGER.info("STUDENT DETAILS -> {}", student);
		LOGGER.info("STUDENT PASSPORT DETAILS -> {}", student.getPassport());
		// ONE TO ONE MAPPING eager fetch is happening
		//To make it lazy we should use in Student entity
		//@OneToOne(fetch = FetchType.LAZY)
		//private Passport passport;
		
		
//		Error when @OneToOne(fetch = FetchType.LAZY) solution use @Transactional at method level
//		org.hibernate.LazyInitializationException: could not initialize proxy
//		 [com.example.springboothibernateonetoonemapping.entity.Passport#40001] 
//		 - no Session
	}
	
	@Test
	@Transactional
	void retrievePassportAndThenStudentDetailsFromStudent() {
		Passport passport= em.find(Passport.class,40001);
		LOGGER.info("PASSPORT DETAILS -> {}", passport);
		LOGGER.info("PASSPORT associated STUDENT  DETAILS -> {}", passport.getStudent());
		// ONE TO ONE MAPPING eager fetch is happening
		//To make it lazy we should use in Student and passport entity
		//@OneToOne(fetch = FetchType.LAZY)
		//private Passport passport;
		
//		public class Passport {
//		@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
//		private Student student;
		
		
//		Error when @OneToOne(fetch = FetchType.LAZY) solution use @Transactional at method level
//		org.hibernate.LazyInitializationException: could not initialize proxy
//		 [com.example.springboothibernateonetoonemapping.entity.Passport#40001] 
//		 - no Session
	}
	
	@Test
	@Transactional
	void playWithPersistenceContextUsingEnityManager() {
		// Session & SessionFactory
		// EntityManager & PersistenceContext
		// What should happen if any of the 4 db operation fails 
		// whole transaction should fail of till what it is successful that should be saved in db
		// Ideally either everything should succeed or nothing should succeed
//		whenever we define @Transactional it will create PersistenceContext 
//		where all entities are getting saved
		// Database operation1 Retrieve Student
		Student student= em.find(Student.class,20001);
		//Now PersistenceContext  has (Student) entity
		
		// Database operation1 Retrieve Passport
		Passport passport = student.getPassport();
		//Now PersistenceContext  has (Student & Passport) entity
		
		// Database operation1 Update Passport
		passport.setNumber("E12345587");
		//Now PersistenceContext  has (Student & Passport++) entity
		
		// Database operation1 Update Student
		student.setName("Ranga Updated");
		//Now PersistenceContext  has (Student++ & Passport++) entity

	}
	
	@Test
	void playWithPersistenceContextUsingStudentRepo() {
		studentRepository.playWithPersistenceContext();
		//here @Transactional is not required at method level 
		// because @Transactional is defined at class level in StudentRepository
	}

}
