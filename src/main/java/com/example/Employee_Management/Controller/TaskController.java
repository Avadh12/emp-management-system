package com.example.Employee_Management.Controller;

import com.example.Employee_Management.Service.TaskService;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.Task;
import com.example.Employee_Management.entity.TaskAllotment;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import com.example.Employee_Management.model.TaskCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/api/v1/Task")
    public ResponseEntity<String> createTask(@RequestBody TaskCreateRequest Request) {
        taskService.createTask(Request);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/api/v1/Task")
    private List<Task> getAll() {
        return taskService.getAll();
    }
    @DeleteMapping("/api/v1/Task")
    private void DeleteAllStudent() {
        taskService.deleteAll();
    }


    @GetMapping("/api/v1/Task/{taskid}")
    public ResponseEntity<Task>getTaskByID(@PathVariable Integer taskid) {
        return ResponseEntity.ok(taskService.getTaskByID(taskid));
    }

    @DeleteMapping("/api/v1/Task/{taskid}")
    private void DeleteTask(@PathVariable Integer taskid){
        taskService.deleteByID(taskid);
    }

    @PutMapping("/api/v1/Task/{taskid}")
    private void updateTask(@PathVariable Integer taskid ,@RequestBody Task task2){
        taskService.update(task2,taskid);
    }

}



