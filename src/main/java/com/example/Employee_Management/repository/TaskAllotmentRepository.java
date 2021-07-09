package com.example.Employee_Management.repository;
import com.example.Employee_Management.entity.TaskAllotment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskAllotmentRepository extends CrudRepository<TaskAllotment,Integer> {
    List<TaskAllotment> findAll();


    @Query("SELECT a from TaskAllotment a where a.status='pending'")
    List<TaskAllotment> findTaskAllotmentByStatusEquals(String string);


    @Query("SELECT a,b from TaskAllotment a join fetch a.employee b " +
            "where a.status='COMPLETE' order by b.name")
    List<TaskAllotment> findTaskAllotmentByStatus();

    @Modifying
    @Query(nativeQuery = true, value = "select i.name, avg(a.ranking) from taskAllotment a join " +
            "employee i on i.id = a.empId group by i.name limit 10")
    List<TaskAllotment> findTaskAllotmentByRankingIsGreaterThanEqual();

}
