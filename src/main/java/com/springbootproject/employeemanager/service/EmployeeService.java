package com.springbootproject.employeemanager.service;

import com.springbootproject.employeemanager.model.Employee;
import com.springbootproject.employeemanager.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;


@Service // Service Logic
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired // For injecting dependency injection
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // At this point the repository employeeRepo is used to perform CRUD Operations

    // Method for adding the employee
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString()); // Random UUID
        return  employeeRepo.save(employee); // Saving
    }

    // employeeRepo - Using this repository here to perform these operations

    // Method to return a list of all employees
    public List<Employee> findallEmployees(){
        return employeeRepo.findAll();
    }

    // Method to update the employee
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    // Method to find the employee by id
    // If we don't find an employee by id, the exception is raised
    public Employee findEmployeeById(Long id) {
        try {
            return  employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserPrincipalNotFoundException("User by id " + id + " was not found"));
        } catch (UserPrincipalNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to delete the employee
    // Passing id as a parameter
    @Transactional
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
