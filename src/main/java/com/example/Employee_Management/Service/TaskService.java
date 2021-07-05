package com.example.Employee_Management.Service;

import com.example.Employee_Management.Repository.TaskRepository;
import com.example.Employee_Management.entity.Task;
import com.example.Employee_Management.model.ProjectCreateRequest;
import com.example.Employee_Management.model.TaskCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void createUser(TaskCreateRequest request) {
        if (request.getTaskDescription().equals("")) throw new RuntimeException("Throwing runtime Error");

        Task task = new Task();
        task.setTaskDescription(request.getTaskDescription());


        taskRepository.save(task);

    }
}
