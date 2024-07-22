package com.employeeproject.cruddemo.repository;

import com.employeeproject.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    @Query(value = "SELECT * FROM employee WHERE first_name = :firstName", nativeQuery = true)
    Employee findByFirstName(@Param("firstName") String firstName);
}
