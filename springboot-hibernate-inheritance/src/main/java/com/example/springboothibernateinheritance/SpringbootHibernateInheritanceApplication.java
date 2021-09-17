package com.example.springboothibernateinheritance;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboothibernateinheritance.dao.EmployeeRepository;
import com.example.springboothibernateinheritance.entity.Employee;
import com.example.springboothibernateinheritance.entity.FullTimeEmployee;
import com.example.springboothibernateinheritance.entity.PartTimeEmployee;

@SpringBootApplication
public class SpringbootHibernateInheritanceApplication implements CommandLineRunner{

	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootHibernateInheritanceApplication.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateInheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee partTimeEmployee=new PartTimeEmployee("Jill",new BigDecimal(50));
		employeeRepository.insert(partTimeEmployee);
		
		Employee fullTimeEmployee=new FullTimeEmployee("Jack",new BigDecimal(10008));
		employeeRepository.insert(fullTimeEmployee);
		
		LOGGER.info("List of Employees --> {}", employeeRepository.findAllEmployee());
	}

}
