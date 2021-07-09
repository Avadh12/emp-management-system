package com.example.Employee_Management.controller;
import com.example.Employee_Management.service.TaskService;
import com.example.Employee_Management.entity.Task;
import com.example.Employee_Management.model.TaskCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/v1/task")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody TaskCreateRequest request) {
       return taskService.createTask(request);

    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Task> getAll() {
        return taskService.getAll();
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    private void DeleteAllTaskController() {
        taskService.deleteAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskByID(@PathVariable Integer id) {
        return taskService.getTaskByID(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void DeleteTask(@PathVariable Integer id){
        taskService.deleteByID(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void updateTask(@PathVariable Integer id, @RequestBody Task task){
        taskService.update(task, id);
    }
}



