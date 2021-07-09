package com.example.Employee_Management.controller;

import com.example.Employee_Management.service.ProjectService;

import com.example.Employee_Management.entity.Project;

import com.example.Employee_Management.model.ProjectCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<String> createProject(@RequestBody ProjectCreateRequest request) {
        projectService.createProject(request);
        return ResponseEntity.ok("Created");
    }


    @GetMapping
    private List<Project> getAll(){
        return projectService.getAll();
}


    @DeleteMapping
    private void DeleteAllStudent() {
        projectService.deleteAll();
    }

    @GetMapping("/{id}")
    public Project getProjectByID(@PathVariable Integer id){
        return projectService.getProjectByID(id);
    }


    @DeleteMapping("/{id}")
    private void DeleteProject(@PathVariable Integer id){
        projectService.deleteByID(id);
    }

    @PutMapping("/{id}")
    private void changeProject(@PathVariable Integer id, @RequestBody Project project){
        projectService.update(project, id);
    }


}
