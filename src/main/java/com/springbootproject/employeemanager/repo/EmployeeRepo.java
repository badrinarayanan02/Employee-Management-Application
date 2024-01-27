package com.springbootproject.employeemanager.repo;

import com.springbootproject.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id); // Spring understands the language and create the query for deleting the employee using id

    Optional<Employee> findEmployeeById(Long id); // Optional - Situation where we might not have an employee by that id

    // This is called as query method because of the naming convention
}
