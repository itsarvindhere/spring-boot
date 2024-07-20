package com.employeeproject.cruddemo.dao;

import com.employeeproject.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // Get a list of all the employees
    List<Employee> findAll();
}
