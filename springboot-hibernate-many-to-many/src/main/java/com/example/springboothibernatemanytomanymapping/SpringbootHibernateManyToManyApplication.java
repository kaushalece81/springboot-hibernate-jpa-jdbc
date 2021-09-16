package com.example.springboothibernatemanytomanymapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboothibernatemanytomanymapping.dao.CourseRepository;
import com.example.springboothibernatemanytomanymapping.dao.StudentRepository;
import com.example.springboothibernatemanytomanymapping.entity.Course;
import com.example.springboothibernatemanytomanymapping.entity.Review;
import com.example.springboothibernatemanytomanymapping.entity.Student;

@SpringBootApplication
public class SpringbootHibernateManyToManyApplication implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateManyToManyApplication.class, args);
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
		
		//studentRepository.insertStudentAndCourseHardCodedValues();
		Student student = new Student("Jack");
		Course course = new Course("Microservice in 50mins");
		studentRepository.insertStudentAndCourse(student, course);
		
	}

}
