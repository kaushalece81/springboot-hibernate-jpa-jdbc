package com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.entity.Course;

@Repository
@Transactional
public class CourseRepository {

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
