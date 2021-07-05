package com.example.Employee_Management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Project_Id;

    @Override
    public String toString() {
        return "Project{" +
                "Project_Id=" + Project_Id +
                ", ProjectName='" + ProjectName + '\'' +
                '}';
    }

    private String ProjectName;
}
