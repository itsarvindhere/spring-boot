package com.restcrudapp.demo.controller;


import com.restcrudapp.demo.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // Define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("James", "Cook"));
        students.add(new Student("Robb", "Stark"));

        return students;
    }
}
