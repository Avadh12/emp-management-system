package com.example.Employee_Management.controller;

import com.example.Employee_Management.service.EmployeeService;

import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeCreateRequest request) {
        employeeService.createUser(request);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee>getUserByID(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getUserByID(id));
    }


    @DeleteMapping("/{id}")
    private void DeleteStudent(@PathVariable Long id) {
        employeeService.deleteByID(id);
    }


    @GetMapping
    private List<Employee> getAll() {
        return employeeService.getAll();
    }

    @DeleteMapping
    private void DeleteAllEmployee() {
        employeeService.deleteAll();
    }


    @PutMapping("/{id}")
    private void updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.update(employee, id);
    }

}



