package com.example.Employee_Management.Service;

import com.example.Employee_Management.Repository.DesignationRepository;
import com.example.Employee_Management.entity.Designation;
import com.example.Employee_Management.model.DesignationCreateRequest;
import com.example.Employee_Management.model.EmployeeCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationService {
    @Autowired
    private DesignationRepository designationRepository;

    public void createUser(DesignationCreateRequest request) {

        if (request.getDesignatedAs().equals("")) throw new RuntimeException("Throwing runtime Error");

        Designation des = new Designation();

        des.setDesignatedAs(request.getDesignatedAs());


        designationRepository.save(des);
    }
}
