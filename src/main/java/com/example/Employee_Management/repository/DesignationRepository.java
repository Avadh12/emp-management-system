package com.example.Employee_Management.repository;

import com.example.Employee_Management.entity.Designation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationRepository extends CrudRepository<Designation,Integer> {
    List<Designation> findAll();
}
