package com.example.springboothibernateonetoonemapping.dao;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboothibernateonetoonemapping.entity.Passport;
import com.example.springboothibernateonetoonemapping.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentRepository.class);

	@Autowired
//	@PersistenceContext
	private EntityManager em;
	
	public Student findStudentById(int id) {
		return em.find(Student.class, id);
	}
	
	public void deleteStudentById(int id) {
		Student findById = em.find(Student.class, id);
		em.remove(findById);
	}
	
	public Student saveOrUpdate(Student student) {
		if(student.getId()==null) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		return student;
	}
	
	public Student saveStudentWithPassport() {
		Passport passport=new Passport("E12345690");
		em.persist(passport);
		
		Student student=new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
		return student;
	}
	
	public void playWithPersistenceContext() {
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
}
