package com.example.Employee_Management.controller;
import com.example.Employee_Management.service.EmployeeService;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody EmployeeCreateRequest request) {
        return employeeService.createUser(request);

    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getUserByID(@PathVariable Long id){
        return employeeService.getUserByID(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void DeleteEmployee(@PathVariable Long id) {
        employeeService.deleteByID(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Employee> getAll() {
        return employeeService.getAll();
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    private void DeleteAllEmployee() {
        employeeService.deleteAll();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void changeEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.update(employee, id);
    }
}



