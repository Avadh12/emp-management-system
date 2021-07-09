package com.example.Employee_Management.controller;
import com.example.Employee_Management.service.ProjectService;
import com.example.Employee_Management.entity.Project;
import com.example.Employee_Management.model.ProjectCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody ProjectCreateRequest request) {
        return projectService.createProject(request);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Project> getAll(){
        return projectService.getAll();}
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    private void DeleteAllProject() {
        projectService.deleteAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project getProjectByID(@PathVariable Integer id){
        return projectService.getProjectByID(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void DeleteProject(@PathVariable Integer id){
        projectService.deleteByID(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void changeProject(@PathVariable Integer id, @RequestBody Project project){
        projectService.update(project, id);
    }
}
