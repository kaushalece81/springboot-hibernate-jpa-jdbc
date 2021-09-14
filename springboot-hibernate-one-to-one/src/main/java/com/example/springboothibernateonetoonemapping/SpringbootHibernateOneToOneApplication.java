package com.example.springboothibernateonetoonemapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboothibernateonetoonemapping.dao.StudentRepository;

@SpringBootApplication
public class SpringbootHibernateOneToOneApplication implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOneToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.saveStudentWithPassport();
		
	}

}
