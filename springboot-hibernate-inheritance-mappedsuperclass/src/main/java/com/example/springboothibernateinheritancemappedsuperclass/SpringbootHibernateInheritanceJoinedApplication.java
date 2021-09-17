package com.example.springboothibernateinheritancemappedsuperclass;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboothibernateinheritancemappedsuperclass.dao.EmployeeRepository;
import com.example.springboothibernateinheritancemappedsuperclass.entity.Employee;
import com.example.springboothibernateinheritancemappedsuperclass.entity.FullTimeEmployee;
import com.example.springboothibernateinheritancemappedsuperclass.entity.PartTimeEmployee;

@SpringBootApplication
public class SpringbootHibernateInheritanceJoinedApplication implements CommandLineRunner{

	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootHibernateInheritanceJoinedApplication.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateInheritanceJoinedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee partTimeEmployee=new PartTimeEmployee("Jill",new BigDecimal(50));
		employeeRepository.insert(partTimeEmployee);
		
		Employee fullTimeEmployee=new FullTimeEmployee("Jack",new BigDecimal(10008));
		employeeRepository.insert(fullTimeEmployee);
		
//		LOGGER.info("List of Employees --> {}", employeeRepository.findAllEmployee());
		LOGGER.info("List of All Part Time Employees --> {}", employeeRepository.findAllPartTimeEmployee());
		LOGGER.info("List of All Full Time Employees --> {}", employeeRepository.findAllFullTimeEmployee());
	}

}
