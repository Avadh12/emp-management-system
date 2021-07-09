package com.example.Employee_Management.controller;
import com.example.Employee_Management.service.DesignationService;
import com.example.Employee_Management.entity.Designation;
import com.example.Employee_Management.model.DesignationCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/designation")
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @PostMapping
    public ResponseEntity<String> createDesignation(@RequestBody DesignationCreateRequest request) {
        designationService.createDesignation(request);
        return ResponseEntity.ok("Created");
    }
    @GetMapping
    private List<Designation> getAll() {
        return designationService.getAll();
    }
    @DeleteMapping
    private void DeleteAllDesignation() {
        designationService.deleteAll();
    }
    @GetMapping("/{id}")
    public Designation getDesignationByID(@PathVariable Integer id){
        return designationService.getDesignationByID(id);
    }
    @DeleteMapping("/{id}")
    private void DeleteDesignation(@PathVariable Integer id){
        designationService.deleteByID(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void changeDesignation(@PathVariable Integer id, @RequestBody Designation designation){
        designationService.update(designation, id);
    }
}
