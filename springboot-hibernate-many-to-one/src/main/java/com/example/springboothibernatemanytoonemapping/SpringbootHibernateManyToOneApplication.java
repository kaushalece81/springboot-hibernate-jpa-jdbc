package com.example.springboothibernatemanytoonemapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboothibernatemanytoonemapping.dao.CourseRepository;
import com.example.springboothibernatemanytoonemapping.dao.StudentRepository;
import com.example.springboothibernatemanytoonemapping.entity.Review;

@SpringBootApplication
public class SpringbootHibernateManyToOneApplication implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateManyToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//courseRepository.addReviewsForCourseHardCoded();
		List<Review> reviews =new ArrayList<>();
		Review review1 = new Review("4","Awesome course");
		Review review2 = new Review("5","Hats of to you");
		reviews.add(review1);
		reviews.add(review2);
		courseRepository.addReviewsForCourse(10002,reviews);
		
	}

}
