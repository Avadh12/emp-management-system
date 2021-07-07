package com.example.Employee_Management.Repository;

import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.TaskAllotment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAllotmentRepository extends CrudRepository<TaskAllotment,Integer> {
    List<TaskAllotment> findAll();
}
