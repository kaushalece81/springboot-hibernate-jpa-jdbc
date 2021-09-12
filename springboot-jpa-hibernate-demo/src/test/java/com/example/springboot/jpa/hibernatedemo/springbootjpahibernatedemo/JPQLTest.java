package com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.entity.Course;
@SpringBootTest
class JPQLTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JPQLTest.class);

	@Autowired
	private EntityManager em;
	
	@Test
	void findById_basic() {
		Query createQuery = em.createQuery("Select c from Course c");
		List resultList = createQuery.getResultList();
		LOGGER.info("Select Query using JPQL for COURSE {} ",resultList);
	}
	
	// Typed queries are much better as we are clear what result is expected
	@Test
	void findById_JPQLTypedQuery() {
		TypedQuery<Course> createTypedQuery = em.createQuery("Select c from Course c",Course.class);
		List<Course> resultList = createTypedQuery.getResultList();
		LOGGER.info("Select Query using JPQL for COURSE {} ",resultList);
	}
	
	@Test
	void findById_JPQLTypedQuery_Where() {
		TypedQuery<Course> createTypedQuery = em.createQuery("Select c from Course c where name like '%100 Steps%'",Course.class);
		List<Course> resultList = createTypedQuery.getResultList();
		LOGGER.info("Select Query using JPQL for COURSE {} ",resultList);
	}
	
	@Test
	// Query defined in entity class
	void findById_JPQLNamedQuery() {
		TypedQuery<Course> createTypedQuery = em.createNamedQuery("query_get_all_courses",Course.class);
		List<Course> resultList = createTypedQuery.getResultList();
		LOGGER.info("Select Query using JPQL for COURSE {} ",resultList);
	}
	
	@Test
	// Query defined in entity class
	void findById_JPQLNamedQuery100StepsCourses() {
		TypedQuery<Course> createTypedQuery = em.createNamedQuery("query_get_100_steps_courses",Course.class);
		List<Course> resultList = createTypedQuery.getResultList();
		LOGGER.info("Select Query using JPQL for COURSE {} ",resultList);
	}

}
