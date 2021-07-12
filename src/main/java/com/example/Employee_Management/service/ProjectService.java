package com.example.Employee_Management.service;
import com.example.Employee_Management.repository.ProjectRepository;
import com.example.Employee_Management.entity.Project;
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
    public Project createProject(ProjectCreateRequest request) {
        if (request.getProjectName().equals("")) throw new RuntimeException("");
        Project project = new Project();
        project.setProjectName(request.getProjectName());

        projectRepository.save(project);
        return project;
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
        Project project=new Project();
        return projectOptional.orElse(project);
    }
    public void deleteByID(Integer projectID){
        projectRepository.deleteById(projectID);
    }
    public void update(Project project,Integer projectID){
        Optional<Project>projectOptional = projectRepository.findById(projectID);
        Project projectObject=new Project();
        Project projectObj = projectOptional.orElse(projectObject);

        projectObj.setProjectName(project.getProjectName());
        projectRepository.save(projectObj);
    }
}