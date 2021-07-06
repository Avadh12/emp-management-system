package com.example.Employee_Management.Service;


import com.example.Employee_Management.Repository.EmployeeRepository;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void createUser(EmployeeCreateRequest request) {

        if (request.getName().equals("")) throw new RuntimeException("Throwing runtime Error");
        Employee emp = new Employee();
        emp.setName(request.getName());
        emp.setDest_id(request.getDest_id());
        emp.setMobile_No(request.getMobile_No());
        emp.setAddress(request.getAddress());
        emp.setPostalCode(request.getPostalCode());
        emp.setStart_date(request.getStartDate());
        emp.setEnd_date(request.getEndDate());
        emp.setSalary(request.getSalary());
        emp.setStatus(request.getStatus());

        employeeRepository.save(emp);
    }


    public Employee getUserByID (Long userID){

        Optional<Employee> studentOptional = employeeRepository.findById(userID);
        return studentOptional.orElseGet(Employee::new);
    }



}
