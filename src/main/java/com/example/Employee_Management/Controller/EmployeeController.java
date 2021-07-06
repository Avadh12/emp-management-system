package com.example.Employee_Management.Controller;

import com.example.Employee_Management.Service.EmployeeService;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@RestController
//@RequestMapping("/api/v1/Project")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/api/v1/project")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeCreateRequest Request) {
        employeeService.createUser(Request);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/api/v1/Project/{userid}")
    public ResponseEntity<Employee>getUserByID(@PathVariable Long userid){
        return ResponseEntity.ok(employeeService.getUserByID(userid));
    }





}



