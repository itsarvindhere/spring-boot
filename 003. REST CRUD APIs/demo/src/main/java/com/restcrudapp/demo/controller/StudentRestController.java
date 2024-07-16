package com.restcrudapp.demo.controller;


import com.restcrudapp.demo.exception.StudentNotFoundException;
import com.restcrudapp.demo.pojo.Student;
import com.restcrudapp.demo.pojo.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (id >= students.size() || id < 0) {
            throw new StudentNotFoundException("Student id not found - " + id);
        }
        return students.get(id);
    }

    // Exception Handler for the StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException e) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Exception Handler for the Generic Exceptions

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StudentErrorResponse> handleGenericExceptions(Exception e) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
