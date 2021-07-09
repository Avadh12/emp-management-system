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
    public Employee createUser(EmployeeCreateRequest request) {
        if (request.getName().equals("")) throw new RuntimeException("");
        Employee employee = new Employee();
        employee.setName(request.getName());
        Designation designation = new Designation();
        designation.setDesignationId(request.getDestId());
        employee.setDesignation(designation);
        employee.setMobileNo(request.getMobileNo());
        employee.setAddress(request.getAddress());
        employee.setPostalCode(request.getPostalCode());
        employee.setStartDate(request.getStartDate());
        employee.setEndDate(request.getEndDate());
        employee.setSalary(request.getSalary());
        employee.setStatus(request.getStatus());
        employeeRepository.save(employee);
        return employee;
    }
    public Employee getUserByID(Long userID) {
        Optional<Employee> studentOptional = employeeRepository.findById(userID);
        Employee employee = new Employee();
        return studentOptional.orElse(employee);
    }
    public void deleteByID(Long userID) {
        employeeRepository.deleteById(userID);
    }
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
    public void update(Employee employeeObj, Long userID) {
        Optional<Employee> employeeOptional = employeeRepository.findById(userID);
        Employee employeeObject=new Employee();
        Employee employee = employeeOptional.orElse(employeeObject);
        employee.setDesignation(employeeObj.getDesignation());
        employee.setName(employeeObj.getName());
        employee.setPostalCode(employeeObj.getPostalCode());
        employee.setAddress(employeeObj.getAddress());
        employee.setEndDate(employeeObj.getEndDate());
        employee.setStartDate(employeeObj.getStartDate());
        employee.setSalary(employeeObj.getSalary());
        employee.setStatus(employeeObj.getStatus());
        employee.setMobileNo(employeeObj.getMobileNo());
        employeeRepository.save(employee);
    }
}
