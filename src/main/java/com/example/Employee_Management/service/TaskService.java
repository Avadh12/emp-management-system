package com.example.Employee_Management.service;
import com.example.Employee_Management.repository.TaskRepository;
import com.example.Employee_Management.entity.Project;
import com.example.Employee_Management.entity.Task;
import com.example.Employee_Management.model.TaskCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public Task createTask(TaskCreateRequest request) {
        if (request.getTaskDescription().equals("")) throw new RuntimeException("");
        Task task = new Task();
        task.setTaskDescription(request.getTaskDescription());
        Project project = new Project();
        project.setProjectId((request.getProjectId()));
        task.setProject(project);
        taskRepository.save(task);
        return task;
    }
    public List<Task> getAll(){
        List<Task>tasks = new ArrayList<Task>();
        taskRepository.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }
    public void deleteAll (){
        taskRepository.deleteAll();
    }
    public Task getTaskByID(Integer taskID){
        Optional<Task>taskOptional = taskRepository.findById(taskID);
        Task task=new Task();
        return taskOptional.orElse(task);
    }
    public void deleteByID(Integer taskID){
        taskRepository.deleteById(taskID);
    }
    public void update(Task task,Integer taskID){
        Optional<Task> taskOptional = taskRepository.findById(taskID);
        Task taskObject=new Task();
        Task taskObj = taskOptional.orElse(taskObject);
        taskObj.setTaskId(task.getTaskId());
        taskObj.setTaskDescription(task.getTaskDescription());
        taskObj.setProject(task.getProject());
        taskRepository.save(taskObj);
    }
}
