package com.employeeproject.cruddemo.dao;

import com.employeeproject.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // Entity Manager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // Create a Query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // Return the result list
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void delete(int id) {

        // Find the employee with the specific id in the database
        Employee employee = entityManager.find(Employee.class, id);

        // Delete the employee if it exists
        if (null != employee) {
            entityManager.remove(employee);
        }
    }
}
