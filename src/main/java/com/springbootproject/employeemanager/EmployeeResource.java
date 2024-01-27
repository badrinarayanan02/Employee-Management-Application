// Adding controller functionality

package com.springbootproject.employeemanager;

import com.springbootproject.employeemanager.model.Employee;
import com.springbootproject.employeemanager.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// API Endpoints
@RestController // Because this is a rest service
@RequestMapping("/employee") // Giving this whole class a base URL by using RequestMapping
// To access the employee resource all the URL needs to have employee as base in the URL


public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Functionality to return all the employee that we have in the application
    // Using GetMapping because this is a get request

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        // Call the service
        List<Employee> employees = employeeService.findallEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK); // Status Code - 200 Success
    }

    // Functionality to find a employee by id
    @GetMapping("/find/{id}") // id as a path parameter
    // Taking the id using annotation called PathVariable by specifying the type, id should match
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        // Call the service
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK); // Status Code - 200 Success
    }

    // Functionality to add an employee
    // As this is post request, using PostMapping
    @PostMapping("/add")
    // To get the body of the request using RequestBody
        public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
            Employee newemployee = employeeService.addEmployee(employee);
            return new ResponseEntity<>(newemployee, HttpStatus.CREATED); // Status code Response (Created) for successfully adding new employee
    }

    // Functionality to update an employee
    // As this is update request, using PutMapping
    @PutMapping("/update")
    // To get the body of the request using RequestBody
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>("Employee with id " + employee.getId() + " was updated successfully!",HttpStatus.OK);
    }

    // Functionality to delete an employee
    @Transactional
    @DeleteMapping("/delete/{id}") // Path Parameter
    // To get the body of the request using RequestBody
    // This method doesn't return anything
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee with id " + id + " was deleted successfully!",HttpStatus.OK);
    }

}
