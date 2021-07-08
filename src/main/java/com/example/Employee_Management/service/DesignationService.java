package com.example.Employee_Management.service;
import com.example.Employee_Management.repository.DesignationRepository;
import com.example.Employee_Management.entity.Designation;
import com.example.Employee_Management.model.DesignationCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DesignationService {
    @Autowired
    private DesignationRepository designationRepository;

    public void createDesignation(DesignationCreateRequest request) {

        if (request.getDesignatedAs().equals("")) throw new RuntimeException("");
        Designation designation = new Designation();
        designation.setDesignatedAs(request.getDesignatedAs());
        designationRepository.save(designation);
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
        Designation designation = new Designation();
        return designationOptional.orElse(designation);
    }
    public void deleteByID(Integer designationID){
        designationRepository.deleteById(designationID);
    }

    public void update(Designation designation,Integer designationID){
        Optional<Designation>designationOptional = designationRepository.findById(designationID);
        Designation destObj =new Designation();
        Designation dest = designationOptional.orElse(destObj);
        dest.setDesignatedAs(designation.getDesignatedAs());
        designationRepository.save(dest);
    }
}
