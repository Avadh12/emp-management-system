package com.example.Employee_Management.service;

import com.example.Employee_Management.repository.TaskAllotmentRepository;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.Task;
import com.example.Employee_Management.entity.TaskAllotment;
import com.example.Employee_Management.model.TaskAllotmentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskAllotmentService {
    @Autowired
    private TaskAllotmentRepository taskAllotmentRepository;
    public void createTaskAllotment(TaskAllotmentCreateRequest request){
        if (request.getEndDate().equals("")) throw new RuntimeException("");

        TaskAllotment allotment = new TaskAllotment();
        allotment.setEndDate(request.getEndDate());
        Employee employee = new Employee();
        employee.setEmpId(request.getEmpId());
        allotment.setEmployee(employee);
        allotment.setFeedback(request.getFeedback());
        allotment.setStatus(request.getStatus());
        Task task = new Task();
        task.setTaskId(request.getTaskId());
        allotment.setTask(task);
     //   allotment.setTaskId(request.getTaskId());
        allotment.setRanking(request.getRanking());
        allotment.setStartDate(request.getStartDate());

        taskAllotmentRepository.save(allotment);
    }
    public List<TaskAllotment> getAll()
    {
        List<TaskAllotment>taskAllotments = new ArrayList<TaskAllotment>();
        taskAllotmentRepository.findAll().forEach(taskAllotment -> taskAllotments.add(taskAllotment));
        return taskAllotments;
    }
    public void deleteAll (){
        taskAllotmentRepository.deleteAll();
    }

    public TaskAllotment getTaskAllotmentByID(Integer taskAllotmentID){
        Optional<TaskAllotment>taskAllotmentOptional = taskAllotmentRepository.findById(taskAllotmentID);
        TaskAllotment taskAllotment=new TaskAllotment();
        return taskAllotmentOptional.orElse(taskAllotment);
    }
    public void deleteByID(Integer taskAllotmentID){
        taskAllotmentRepository.deleteById(taskAllotmentID);
    }

    public void update(TaskAllotment taskAllotment, Integer taskAllotmentID){
        Optional<TaskAllotment> taskAllotmentOptional = taskAllotmentRepository.findById(taskAllotmentID);
        TaskAllotment taskAllotmentObj=new TaskAllotment();
        TaskAllotment taskAllot = taskAllotmentOptional.orElse(taskAllotmentObj);

        taskAllot.setTaskAllotedId(taskAllotment.getTaskAllotedId());
        taskAllot.setTask(taskAllotment.getTask());
        taskAllot.setStatus(taskAllotment.getStatus());
        taskAllot.setFeedback(taskAllotment.getFeedback());
        taskAllot.setStartDate(taskAllotment.getStartDate());
        taskAllot.setRanking(taskAllotment.getRanking());
        taskAllot.setEndDate(taskAllotment.getEndDate());
        taskAllot.setEmployee(taskAllotment.getEmployee());
        taskAllotmentRepository.save(taskAllot);
    }


}
