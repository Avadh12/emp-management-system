package com.example.Employee_Management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Designation_Id;
    private String DesignatedAs;

    @Override
    public String toString() {
        return "Designation{" +
                "Designation_Id=" + Designation_Id +
                ", DesignatedAs='" + DesignatedAs + '\'' +
                '}';
    }
}

