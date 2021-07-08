package com.example.Employee_Management.repository;

import com.example.Employee_Management.entity.TaskAllotment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAllotmentRepository extends CrudRepository<TaskAllotment,Integer> {
    List<TaskAllotment> findAll();

//@Query("SELECT id from taskAllotment id where id.ranking=?1")
//    public List<TaskAllotment> getTaskAllotmentByByRanking(Integer ranking);
//

}
