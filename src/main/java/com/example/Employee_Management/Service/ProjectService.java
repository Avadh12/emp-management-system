package com.example.Employee_Management.Service;

import com.example.Employee_Management.Repository.ProjectRepository;
import com.example.Employee_Management.entity.Designation;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.Project;
import com.example.Employee_Management.model.DesignationCreateRequest;
import com.example.Employee_Management.model.ProjectCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public void createProject(ProjectCreateRequest request) {
        if (request.getProjectName().equals("")) throw new RuntimeException("Throwing runtime Error");

        Project project = new Project();


        project.setProjectName(request.getProjectName());

        projectRepository.save(project);
    }

    public List<Project> getAll()
    {
        List<Project>projects = new ArrayList<Project>();
        projectRepository.findAll().forEach(project -> projects.add(project));
        return projects;
    }

    public void deleteAll (){
        projectRepository.deleteAll();
    }

    public Project getProjectByID(Integer projectID){
        Optional<Project> projectOptional = projectRepository.findById(projectID);
        return projectOptional.orElseGet(Project::new);
    }


}