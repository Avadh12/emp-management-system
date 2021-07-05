package com.example.Employee_Management.Repository;

import com.example.Employee_Management.entity.TaskAllotment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAllotmentRepository extends JpaRepository<TaskAllotment,Integer> {
}
