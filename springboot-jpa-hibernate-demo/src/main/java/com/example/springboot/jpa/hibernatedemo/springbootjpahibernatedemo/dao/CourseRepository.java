package com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.entity.Course;

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
	public void playWithEntityManager() {
		LOGGER.info("playWithEntityManager starts===");
		Course course= new Course ("Web services in 100 steps");
		em.persist(course);
		course.setName("Web services in 100 steps Updated");
		//Note here insert and update both query got fired but we did only persist
		//here entity manager keeps track of entity until transaction ends 
		//hence update also happen here entity manager tracked and updated in db

	}
	
	public void playWithEntityManagerWithFlush() {
		LOGGER.info("playWithEntityManagerWithFlush starts===");
		Course course1= new Course ("Web services in 100 steps");
		em.persist(course1);
		//Flush method will save the changes until then into db
		em.flush();
		
		
		course1.setName("Web services in 100 steps Updated");
		em.flush();
		
		Course course2= new Course ("Angular JS in 100 steps");
		em.persist(course2);
		em.flush();
		
		course2.setName("Angular JS in 100 steps Updated");
		em.flush();
	}
	
	public void playWithEntityManagerWithDetachOneCourse() {
		LOGGER.info("playWithEntityManagerWithDetachOneCourse starts===");
		Course course1= new Course ("Web services in 100 steps");
		em.persist(course1);
		//Flush method will save the changes until that point into db
		em.flush();
		
		Course course2= new Course ("Angular JS in 100 steps");
		em.persist(course2);
		em.flush();
		
		em.detach(course2);
		//Detach if we do not want course2 name update changes to go to db
		// Now changes to course2 entity will no longer be tracked by entity manager
		course2.setName("Angular JS in 100 steps Updated");
		course1.setName("Web services in 100 steps Updated");
		//Note but course1 changes will be updated in db as its not detached
		em.flush();
	}
	
	public void playWithEntityManagerWithDetachBothCourse() {
		LOGGER.info("playWithEntityManagerWithDetachBothCourse starts===");
		Course course1= new Course ("Web services in 100 steps");
		em.persist(course1);
		//Flush method will save the changes until that point into db
		em.flush();

		
		Course course2= new Course ("Angular JS in 100 steps");
		em.persist(course2);
		em.flush();
		
		em.detach(course2);
		em.detach(course1);
		//Detach if we do not want course2 & course1 name update changes to go to db
		// Now changes to course2 & course1 entity will no longer be tracked by entity manager
		course2.setName("Angular JS in 100 steps Updated");
		course1.setName("Web services in 100 steps Updated");
		em.flush();
	}
	
	public void playWithEntityManagerWithDetachUsingClear() {
		LOGGER.info("playWithEntityManagerWithDetachUsingClear starts===");
		Course course1= new Course ("Web services in 100 steps");
		em.persist(course1);
		//Flush method will save the changes until that point into db
		em.flush();

		
		Course course2= new Course ("Angular JS in 100 steps");
		em.persist(course2);
		em.flush();
		
		em.clear(); // alternative to detach it will clear every thing
		//Detach using clear if we do not want course2 & course1 name update changes to go to db
		// Now changes to course2 & course1 entity will no longer be tracked by entity manager
		course2.setName("Angular JS in 100 steps Updated");
		course1.setName("Web services in 100 steps Updated");
		em.flush();
	}
	
	public void playWithEntityManagerWithRefresh() {
		LOGGER.info("playWithEntityManagerWithRefresh starts===");
		Course course1= new Course ("Web services in 100 steps");
		em.persist(course1);
		//Flush method will save the changes until that point into db
		em.flush();

		
		Course course2= new Course ("Angular JS in 100 steps");
		em.persist(course2);
		em.flush();
		
		//enitity manager keeps track of changes of course1 and course2
		course2.setName("Angular JS in 100 steps Updated");
		course1.setName("Web services in 100 steps Updated");
		
		em.refresh(course1);// select query will be fired for course1 from db
		//Refesh method gets already saved entity value from DB and 
		//em tracked updated data for course1 will be lost and update will not happen
		
		em.flush();
		// But em will track changes of couse2 as its not refreshed
		// hence update query for couse2 will be fired
	}
}
