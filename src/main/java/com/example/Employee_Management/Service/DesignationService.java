package com.example.Employee_Management.Service;

import com.example.Employee_Management.Repository.DesignationRepository;
import com.example.Employee_Management.entity.Designation;

import com.example.Employee_Management.model.DesignationCreateRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DesignationService {
    @Autowired
    private DesignationRepository designationRepository;

    public void createDesignation(DesignationCreateRequest request) {

        if (request.getDesignatedAs().equals("")) throw new RuntimeException("Throwing runtime Error");

        Designation des = new Designation();

        des.setDesignatedAs(request.getDesignatedAs());


        designationRepository.save(des);
    }

    public List<Designation> getAll()
    {
        List<Designation>designations = new ArrayList<Designation>();
        designationRepository.findAll().forEach(designation -> designations.add(designation));
        return designations;
    }

    public void deleteAll (){
        designationRepository.deleteAll();
    }

    public Designation getDesignationByID(Integer designationID){
        Optional<Designation> designationOptional = designationRepository.findById(designationID);
        return designationOptional.orElseGet(Designation::new);
    }

    public void deleteByID(Integer designationID){
        designationRepository.deleteById(designationID);
    }


    public void update(Designation designation1,Integer designationID){
        Optional<Designation>designationOptional = designationRepository.findById(designationID);
        Designation designation2 = designationOptional.orElseGet(Designation::new);


        designation2.setDesignatedAs(designation1.getDesignatedAs());
        designationRepository.save(designation2);
    }


}
