package com.example.springboot.jdbcdemo.springbootjdbcdemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.jdbcdemo.springbootjdbcdemo.entity.Person;
import com.example.springboot.jdbcdemo.springbootjdbcdemo.jdbc.PersonJdbcDao;

@SpringBootApplication
public class SpringbootJdbcDemoApplication implements CommandLineRunner {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootJdbcDemoApplication.class);

	@Autowired
	private PersonJdbcDao personDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All Users  {} ",personDao.findAll());
		LOGGER.info("Fund User by Id  {} ",personDao.findById(10001));
		LOGGER.info("Delete User by Id  {} ",personDao.deleteById(10003));
		LOGGER.info("Insert User  {} ",personDao.insert(new Person(10004,"Shayam","Bangalore",new Date())));
		LOGGER.info("All Users  {} ",personDao.findAll());
		LOGGER.info("Update User  {} ",personDao.update(new Person(10004,"Shayamu","Bangaluru",new Date())));
		LOGGER.info("All Users  {} ",personDao.findAllByCustomRowMapper());
		
	}

}
