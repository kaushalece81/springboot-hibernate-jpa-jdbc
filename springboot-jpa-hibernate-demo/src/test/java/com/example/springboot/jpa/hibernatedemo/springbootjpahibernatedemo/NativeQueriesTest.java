package com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.entity.Course;
@SpringBootTest
class NativeQueriesTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(JPQLTest.class);

	@Autowired
	private EntityManager em;
	
	@Test
	void selectnativequeries_basic() {
		Query createQuery = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
		List resultList = createQuery.getResultList();
		LOGGER.info("Select Query using Native Query for COURSE {} ",resultList);
	}
	
	@Test
	void selectnativequeries_where() {
		Query createQuery = em.createNativeQuery("SELECT * FROM COURSE where id=?", Course.class);
		createQuery.setParameter(1, 10001);
		List resultList = createQuery.getResultList();
		LOGGER.info("Select Query using Native Query with where clause for COURSE {} ",resultList);
	}
	
	@Test
	void selectnativequeries_with_Named_parameter_where() {
		Query createQuery = em.createNativeQuery("SELECT * FROM COURSE where id= :id", Course.class);
		createQuery.setParameter("id", 10001);
		List resultList = createQuery.getResultList();
		LOGGER.info("Select Query using Native Query named parameter with where clause for COURSE {} ",resultList);
	}
	
	@Test
	void updatenativequeries_with_Named_parameter_where() {
		Query createQuery = em.createNativeQuery("UPDATE COURSE SET last_updated_date=sysdate() where id= :id", Course.class);
		createQuery.setParameter("id", 10001);
		int executeUpdate = createQuery.executeUpdate();
		LOGGER.info("Update Query using Native Query named parameter with where clause for COURSE rows updated {} ",executeUpdate);
	}
	
	@Test
	@Transactional  // its need to update queries
	// There is no way to mass update in one go using JPA using native queries only we can do
	//In jpa we need to get each row and we need to update row by row 
	void updatenativequeries_mass_update() {
		Query createQuery = em.createNativeQuery("UPDATE COURSE SET last_updated_date=sysdate() ", Course.class);

		int executeUpdate = createQuery.executeUpdate();
		LOGGER.info("Update Query mass update using Native Query for COURSE rows updated {} ",executeUpdate);
	}
	
	


}
