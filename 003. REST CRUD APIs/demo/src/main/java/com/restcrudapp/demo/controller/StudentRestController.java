package com.restcrudapp.demo.controller;


import com.restcrudapp.demo.pojo.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // Load the student data using @PostContruct as it is called only once
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("James", "Cook"));
        students.add(new Student("Robb", "Stark"));
    }

    // Define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }


    // Define endpoint for retrieving a single student
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable(value = "studentId") int id) {
        return students.get(id);
    }
}
