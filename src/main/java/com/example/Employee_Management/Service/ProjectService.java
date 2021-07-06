package com.example.Employee_Management.Service;

import com.example.Employee_Management.Repository.ProjectRepository;
import com.example.Employee_Management.entity.Project;
import com.example.Employee_Management.model.DesignationCreateRequest;
import com.example.Employee_Management.model.ProjectCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public void createUser(ProjectCreateRequest request) {
        if (request.getProjectName().equals("")) throw new RuntimeException("Throwing runtime Error");

        Project project = new Project();


        project.setProjectName(request.getProjectName());

        projectRepository.save(project);
    }
}