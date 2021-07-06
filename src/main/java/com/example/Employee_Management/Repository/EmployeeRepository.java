package com.example.Employee_Management.Repository;

import com.example.Employee_Management.entity.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    List<Employee> findAll();



}
