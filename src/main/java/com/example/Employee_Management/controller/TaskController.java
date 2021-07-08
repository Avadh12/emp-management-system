package com.example.Employee_Management.controller;

import com.example.Employee_Management.service.TaskService;

import com.example.Employee_Management.entity.Task;

import com.example.Employee_Management.model.TaskCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/task")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskCreateRequest request) {
        taskService.createTask(request);
        return ResponseEntity.ok("Created");
    }

    @GetMapping
    private List<Task> getAll() {
        return taskService.getAll();
    }


    @DeleteMapping
    private void DeleteAllStudent() {
        taskService.deleteAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Task>getTaskByID(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.getTaskByID(id));
    }

    @DeleteMapping("/{id}")
    private void DeleteTask(@PathVariable Integer id){
        taskService.deleteByID(id);
    }

    @PutMapping("/{id}")
    private void updateTask(@PathVariable Integer id, @RequestBody Task task){
        taskService.update(task, id);
    }

}



