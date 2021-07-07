package com.example.Employee_Management.Service;


import com.example.Employee_Management.Repository.EmployeeRepository;
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

    public void update(Employee emp,Long userID){
        Optional<Employee> employeeOptional = employeeRepository.findById(userID);
        Employee emp1 = employeeOptional.orElseGet(Employee::new);

        emp1.setEmp_id(emp.getEmp_id());
        emp1.setDest_id(emp.getDest_id());
        emp1.setName(emp.getName());
        emp1.setMobile_No(emp.getMobile_No());
        emp1.setStatus(emp.getStatus());
        emp1.setSalary(emp.getSalary());
        emp1.setStart_date(emp.getStart_date());
        emp1.setEnd_date(emp.getEnd_date());
        emp1.setAddress(emp.getAddress());
        emp1.setPostalCode(emp.getPostalCode());
        employeeRepository.save(emp1);
    }

}
