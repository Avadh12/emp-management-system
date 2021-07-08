package com.example.Employee_Management.service;


import com.example.Employee_Management.repository.EmployeeRepository;
import com.example.Employee_Management.entity.Designation;
import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void createUser(EmployeeCreateRequest request) {

        if (request.getName().equals("")) throw new RuntimeException("Throwing runtime Error");
        Employee emp = new Employee();
        emp.setName(request.getName());
        Designation designation = new Designation();
        designation.setDesignation_Id(request.getDest_id());

        emp.setDesignation(designation);
        emp.setMobile_No(request.getMobile_No());
        emp.setAddress(request.getAddress());
        emp.setPostalCode(request.getPostalCode());
        emp.setStart_date(request.getStart_date());
        emp.setEnd_date(request.getEnd_date());
        emp.setSalary(request.getSalary());
        emp.setStatus(request.getStatus());



        employeeRepository.save(emp);
    }


    public Employee getUserByID (Long userID){

        Optional<Employee> studentOptional = employeeRepository.findById(userID);
        return studentOptional.orElseGet(Employee::new);
    }
    public void deleteByID (Long userID){
        employeeRepository.deleteById(userID);
    }



    public List<Employee> getAll()
    {
        List<Employee>employees   = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }

    public void deleteAll (){
        employeeRepository.deleteAll();
    }

    public void update(Employee user1, Long userID){
        Optional<Employee>employeeOptional = employeeRepository.findById(userID);
        Employee user2 = employeeOptional.orElseGet(Employee::new);

        user2.setDesignation(user1.getDesignation());
        user2.setName(user1.getName());
        user2.setPostalCode(user1.getPostalCode());
        user2.setAddress(user1.getAddress());
        user2.setEnd_date(user1.getEnd_date());
        user2.setStart_date(user1.getStart_date());
        user2.setSalary(user1.getSalary());
        user2.setStatus(user1.getStatus());
        user2.setMobile_No(user1.getMobile_No());


        employeeRepository.save(user2);
    }




}
