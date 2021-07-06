package com.example.Employee_Management.Controller;

import com.example.Employee_Management.Service.ProjectService;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.Project;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import com.example.Employee_Management.model.ProjectCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/api/v1/ProjectManage")
    public ResponseEntity<String> createProject(@RequestBody ProjectCreateRequest Request) {
        projectService.createProject(Request);
        return ResponseEntity.ok("Created");
    }
    @GetMapping("/api/v1/ProjectManage")
    private List<Project> getAll(){
        return projectService.getAll();
}


}
