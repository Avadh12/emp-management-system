package com.example.Employee_Management.repository;
import com.example.Employee_Management.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,Integer> {
    List<Task> findAll();
}
