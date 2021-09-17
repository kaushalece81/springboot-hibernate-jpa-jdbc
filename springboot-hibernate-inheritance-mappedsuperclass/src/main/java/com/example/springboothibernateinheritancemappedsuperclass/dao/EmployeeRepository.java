package com.example.springboothibernateinheritancemappedsuperclass.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboothibernateinheritancemappedsuperclass.entity.Employee;
import com.example.springboothibernateinheritancemappedsuperclass.entity.FullTimeEmployee;
import com.example.springboothibernateinheritancemappedsuperclass.entity.PartTimeEmployee;

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
	
//	public List<Employee> findAllEmployee() {
//		 TypedQuery<Employee> createNamedQuery = em.createNamedQuery("find_all_employees",Employee.class);
//		List<Employee> resultList = createNamedQuery.getResultList();
//		return resultList;
//	}
	
	public List<PartTimeEmployee> findAllPartTimeEmployee() {
		 TypedQuery<PartTimeEmployee> createNamedQuery = em.createNamedQuery("find_all_part_time_employees",PartTimeEmployee.class);
		List<PartTimeEmployee> resultList = createNamedQuery.getResultList();
		return resultList;
	}
	
	public List<FullTimeEmployee> findAllFullTimeEmployee() {
		 TypedQuery<FullTimeEmployee> createNamedQuery = em.createNamedQuery("find_all_full_time_employees",FullTimeEmployee.class);
		List<FullTimeEmployee> resultList = createNamedQuery.getResultList();
		return resultList;
	}
	
}
