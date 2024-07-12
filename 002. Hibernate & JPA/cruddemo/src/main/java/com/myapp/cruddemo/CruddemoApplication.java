package com.myapp.cruddemo;

import com.myapp.cruddemo.dao.StudentDAO;
import com.myapp.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication implements CommandLineRunner {

	private StudentDAO studentDAO;

	@Autowired
	public CruddemoApplication(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Create a student object
		System.out.println("Creating a new student object....");
		Student tempStudent = new Student("Paul", "Doe", "paul@google.com");

		// Save the student object in the database
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		// Display the id of the saved student
		System.out.println("Saved student. Generated id: "+ tempStudent.getId());
	}
}
