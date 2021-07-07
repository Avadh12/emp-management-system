package com.example.Employee_Management.Service;

import com.example.Employee_Management.Repository.TaskRepository;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.Task;
import com.example.Employee_Management.entity.TaskAllotment;
import com.example.Employee_Management.model.ProjectCreateRequest;
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

    public void createTask(TaskCreateRequest request) {
        if (request.getTaskDescription().equals("")) throw new RuntimeException("Throwing runtime Error");

        Task task = new Task();
        task.setTaskDescription(request.getTaskDescription());
        task.setProject_id(request.getProject_id());


        taskRepository.save(task);

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
        return taskOptional.orElseGet(Task::new);

    }

    public void deleteByID(Integer taskID){
        taskRepository.deleteById(taskID);
    }


    public void update(Task task1,Integer taskID){
        Optional<Task> taskOptional = taskRepository.findById(taskID);
        Task task2 = taskOptional.orElseGet(Task::new);

        task2.setTask_Id(task1.getTask_Id());
        task2.setTaskDescription(task1.getTaskDescription());
        task2.setProject_id(task1.getProject_id());
        taskRepository.save(task2);
    }




}
