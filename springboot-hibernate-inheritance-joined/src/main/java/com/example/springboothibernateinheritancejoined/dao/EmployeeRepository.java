package com.example.springboothibernateinheritancejoined.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboothibernateinheritancejoined.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	private EntityManager em;
	
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
	public Employee findByEmployeeId(Integer id) {
		return em.find(Employee.class,id);
	}
	
	public List<Employee> findAllEmployee() {
		 TypedQuery<Employee> createNamedQuery = em.createNamedQuery("find_all_employees",Employee.class);
		List<Employee> resultList = createNamedQuery.getResultList();
		return resultList;
	}
	
}
