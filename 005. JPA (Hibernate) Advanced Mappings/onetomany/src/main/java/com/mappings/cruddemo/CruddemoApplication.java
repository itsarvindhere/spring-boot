package com.mappings.cruddemo;

import com.mappings.cruddemo.dao.AppDAO;
import com.mappings.cruddemo.entity.Course;
import com.mappings.cruddemo.entity.Instructor;
import com.mappings.cruddemo.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication implements CommandLineRunner {

	private final AppDAO appDAO;

	@Autowired
	public CruddemoApplication(AppDAO appDAO) {
		this.appDAO = appDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createInstructorWithCourses(appDAO);
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// Create a new "Instructor" object
		Instructor instructor = new Instructor("Susan", "Public", "susan@gmail.com");

		// Create a new "InstructorDetail" object
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/abc", "Guitar");

		// Set the "InstructorDetail"
		instructor.setInstructorDetail(instructorDetail);

		// Create some Courses
		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		// Add the courses to the Instructor
		instructor.add(course1);
		instructor.add(course2);

		// Save the instructor
		System.out.println("Saving the Instructor: " + instructor);
		System.out.println("The courses are: "+ instructor.getCourses());
		appDAO.save(instructor);
		System.out.println("Done!");
	}
}
