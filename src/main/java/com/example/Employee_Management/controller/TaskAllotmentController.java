package com.example.Employee_Management.controller;
import com.example.Employee_Management.service.TaskAllotmentService;
import com.example.Employee_Management.entity.TaskAllotment;
import com.example.Employee_Management.model.TaskAllotmentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/taskallotment")
public class TaskAllotmentController {
@Autowired
    private TaskAllotmentService taskAllotmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskAllotment createTaskAllotment(@RequestBody TaskAllotmentCreateRequest request) {
       return taskAllotmentService.createTaskAllotment(request);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<TaskAllotment> getAll()
    {
        return taskAllotmentService.getAll();
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    private void DeleteAllProject() {
        taskAllotmentService.deleteAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskAllotment getTaskAllotmentByID(@PathVariable Integer id){
        return taskAllotmentService.getTaskAllotmentByID(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void DeleteTaskAllotment(@PathVariable Integer id){
        taskAllotmentService.deleteByID(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void changeTaskAllotment(@PathVariable Integer id,@RequestBody TaskAllotment taskAllotment){
        taskAllotmentService.update(taskAllotment,id);
    }
    @GetMapping("/pending")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskAllotment> getAllStatus() {
        return taskAllotmentService.getPendingTasks();
    }

    @GetMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskAllotment> getEmployee() {
        return taskAllotmentService.getStatus();
    }
    @GetMapping("/ranking")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskAllotment> getRanking() {
        return taskAllotmentService.getAvgRanking();
    }

}
