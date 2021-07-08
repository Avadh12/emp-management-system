package com.example.Employee_Management.Repository;

import com.example.Employee_Management.entity.Employee;
import com.example.Employee_Management.entity.TaskAllotment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAllotmentRepository extends CrudRepository<TaskAllotment,Integer> {
    List<TaskAllotment> findAll();


//    this is for top 10 intern
//    @Query(value ="SELECT alt.dest, avg(r.rating) " +
//            "FROM taskallotment alt " +
//            "INNER JOIN " +
//            "ratings r " +
//            "ON emp.emp_id = r.emp_id " +
//            "WHERE emp.name LIKE %:name% " +
//            "GROUP BY emp.dest " +
//            "ORDER BY avg(r.rating) DESC " +
//            "LIMIT 10",
//            nativeQuery = true)
//    List<Employee[]> topTenEmployeeByRating(@Param("name") String name);

 //   Select top 10 from Employee where Employee.emp_id = task allotment. Emp_id and (select * from task allotment where rating =5 )

}
