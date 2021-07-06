package com.example.Employee_Management.Controller;

import com.example.Employee_Management.Service.TaskAllotmentService;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.TaskAllotment;
import com.example.Employee_Management.model.TaskAllotmentCreateRequest;
import com.example.Employee_Management.model.TaskCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskAllotmentController {
@Autowired
    private TaskAllotmentService taskAllotmentService;

    @PostMapping("/api/v1/TaskAllotment")
    public ResponseEntity<String> createTaskAllotment(@RequestBody TaskAllotmentCreateRequest Request) {
        taskAllotmentService.createTaskAllotment(Request);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/api/v1/TaskAllotment")
    private List<TaskAllotment> getAll()
    {
        return taskAllotmentService.getAll();
    }

}
