package com.example.Employee_Management.repository;
import com.example.Employee_Management.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer> {
    List<Project> findAll();
}
