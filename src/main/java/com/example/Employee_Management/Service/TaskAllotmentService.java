package com.example.Employee_Management.Service;

import com.example.Employee_Management.Repository.TaskAllotmentRepository;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.TaskAllotment;
import com.example.Employee_Management.model.DesignationCreateRequest;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import com.example.Employee_Management.model.ProjectCreateRequest;
import com.example.Employee_Management.model.TaskAllotmentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskAllotmentService {
    @Autowired
    private TaskAllotmentRepository taskAllotmentRepository;
    public void createTaskAllotment(TaskAllotmentCreateRequest request){
        if (request.getEnd_date().equals("")) throw new RuntimeException("Throwing runtime Error");

        TaskAllotment allotment = new TaskAllotment();
        allotment.setEnd_date(request.getEnd_date());
        allotment.setEmp_id(request.getEmp_id());

        allotment.setFeedback(request.getFeedback());
        allotment.setStatus(request.getStatus());

        taskAllotmentRepository.save(allotment);
    }
    public List<TaskAllotment> getAll()
    {
        List<TaskAllotment>taskAllotments = new ArrayList<TaskAllotment>();
        taskAllotmentRepository.findAll().forEach(taskAllotment -> taskAllotments.add(taskAllotment));
        return taskAllotments;
    }

}
