package com.example.springboothibernateonetoonemapping.dao;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboothibernateonetoonemapping.entity.Course;

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
}
