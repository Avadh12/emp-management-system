package com.example.Employee_Management.Controller;

import com.example.Employee_Management.Service.DesignationService;
import com.example.Employee_Management.entity.Designation;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.model.DesignationCreateRequest;
import com.example.Employee_Management.model.TaskCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @PostMapping("/api/v1/Designation")
    public ResponseEntity<String> createDesignation(@RequestBody DesignationCreateRequest Request) {
        designationService.createDesignation(Request);
        return ResponseEntity.ok("Created");
    }
    @GetMapping("/api/v1/Designation")
    private List<Designation> getAll() {
        return designationService.getAll();
    }
    @DeleteMapping("/api/v1/Designation")
    private void DeleteAllStudent() {
        designationService.deleteAll();
    }

    @GetMapping("/api/v1/Designation/{designationid}")
    public ResponseEntity<Designation>getDesignationByID(@PathVariable Integer designationid){
        return ResponseEntity.ok(designationService.getDesignationByID(designationid));
    }

    @DeleteMapping("/api/v1/Designation/{designationid}")
    private void DeleteDesignation(@PathVariable Integer designationid){
        designationService.deleteByID(designationid);
    }

}
