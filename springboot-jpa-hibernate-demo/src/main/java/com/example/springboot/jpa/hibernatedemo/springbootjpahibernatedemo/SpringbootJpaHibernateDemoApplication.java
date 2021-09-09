package com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.jpa.hibernatedemo.springbootjpahibernatedemo.dao.CourseRepository;

@SpringBootApplication
public class SpringbootJpaHibernateDemoApplication implements CommandLineRunner{

	@Autowired
	private CourseRepository courseRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootJpaHibernateDemoApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaHibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Find Course by Id ==== {} ", courseRepository.findCourseById(10001));
		
	}

}
