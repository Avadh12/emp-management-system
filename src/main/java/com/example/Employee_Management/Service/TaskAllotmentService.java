package com.example.Employee_Management.Service;

import com.example.Employee_Management.Repository.TaskAllotmentRepository;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.Project;
import com.example.Employee_Management.entity.Task;
import com.example.Employee_Management.entity.TaskAllotment;
import com.example.Employee_Management.model.DesignationCreateRequest;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import com.example.Employee_Management.model.ProjectCreateRequest;
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
        if (request.getEnd_date().equals("")) throw new RuntimeException("Throwing runtime Error");

        TaskAllotment allotment = new TaskAllotment();
        allotment.setEnd_date(request.getEnd_date());
        allotment.setEmp_id(request.getEmp_id());

        allotment.setFeedback(request.getFeedback());
        allotment.setStatus(request.getStatus());
        allotment.setTask_Id(request.getTask_Id());
        allotment.setRanking(request.getRanking());
        allotment.setStart_date(request.getStart_date());

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
        return taskAllotmentOptional.orElseGet(TaskAllotment::new);
    }
    public void deleteByID(Integer taskAllotmentID){
        taskAllotmentRepository.deleteById(taskAllotmentID);
    }

    public void update(TaskAllotment taskAllotment1, Integer taskAllotmentID){
        Optional<TaskAllotment> taskAllotmentOptional = taskAllotmentRepository.findById(taskAllotmentID);
        TaskAllotment taskAllotment2 = taskAllotmentOptional.orElseGet(TaskAllotment::new);

        taskAllotment2.setTaskAllotedId(taskAllotment1.getTaskAllotedId());
        taskAllotment2.setTask_Id(taskAllotment1.getTask_Id());
        taskAllotment2.setStatus(taskAllotment1.getStatus());
        taskAllotment2.setFeedback(taskAllotment1.getFeedback());
        taskAllotment2.setStart_date(taskAllotment1.getStart_date());
        taskAllotment2.setRanking(taskAllotment1.getRanking());
        taskAllotment2.setEnd_date(taskAllotment1.getEnd_date());
        taskAllotment2.setEmp_id(taskAllotment1.getEmp_id());
        taskAllotmentRepository.save(taskAllotment2);
    }

}
