package com.example.springboot.jpademo.springbootjpademo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.jpademo.springbootjpademo.entity.Person;
import com.example.springboot.jpademo.springbootjpademo.jpa.PersonJpaDao;

@SpringBootApplication
public class SpringbootJpaDemoApplication implements CommandLineRunner {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootJpaDemoApplication.class);

	@Autowired
	private PersonJpaDao personDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All Users  {} ",personDao.findAll());
		LOGGER.info("Find User by Id  {} ",personDao.findById(10001));
		
		LOGGER.info("Insert User  {} ",personDao.insert(new Person(10004,"Shayam","Bangalore",new Date())));
		LOGGER.info("Insert User  {} ",personDao.insert(new Person("Tara","Bangalore",new Date())));
		LOGGER.info("All Users  {} ",personDao.findAll());
		LOGGER.info("Update User  {} ",personDao.update(new Person(10003,"divyanshu","Bangaluru",new Date())));
		LOGGER.info("All Users  {} ",personDao.findAll());
		personDao.deleteById(10002);
		LOGGER.info("All Users  {} ",personDao.findAll());
	}

}
