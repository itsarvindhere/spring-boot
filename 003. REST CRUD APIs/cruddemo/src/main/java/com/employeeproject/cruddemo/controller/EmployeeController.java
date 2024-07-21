package com.employeeproject.cruddemo.controller;

import com.employeeproject.cruddemo.entity.Employee;
import com.employeeproject.cruddemo.exception.EmployeeNotFoundException;
import com.employeeproject.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    // Inject Employee Service
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    // Expose "/employees/id" and return the employee that has the specific id
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") int id) {
        Employee employee = employeeService.findById(id);

        // If the employee does not exist with the passed id, then throw an exception
        if (null == employee) {
            throw new EmployeeNotFoundException("Employee id not found: " + id);
        }

        return employee;
    }

    // Expose "/employees" and add the employee to the database
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    // Expose "/employees" and update the employee in the database
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        // Call the service method to update the employee
        return employeeService.save(employee);
    }

    // Expose "/employees/id" and delete the employee from the database
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id) {

        // Find the employee with the specific id
        Employee employee = employeeService.findById(id);

        // If the employee does not exist with the passed id, then throw an exception
        if (null == employee) {
            throw new EmployeeNotFoundException("Employee id not found: " + id);
        }

        // Call the service method to delete the employee
        employeeService.delete(employee);

        return "Employee with id " + id + " deleted!";
    }
}
