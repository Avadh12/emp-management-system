package com.example.Employee_Management.controller;
import com.example.Employee_Management.service.DesignationService;
import com.example.Employee_Management.entity.Designation;
import com.example.Employee_Management.model.DesignationCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/designation")
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Designation createDesignation(@RequestBody DesignationCreateRequest request) {
       return designationService.createDesignation(request);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Designation> getAll() {
        return designationService.getAll();
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    private void DeleteAllDesignation() {
        designationService.deleteAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Designation getDesignationByID(@PathVariable Integer id){
        return designationService.getDesignationByID(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void DeleteDesignation(@PathVariable Integer id){
        designationService.deleteByID(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void changeDesignation(@PathVariable Integer id, @RequestBody Designation designation){
        designationService.update(designation, id);
    }
}
