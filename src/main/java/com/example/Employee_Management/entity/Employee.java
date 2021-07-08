package com.example.Employee_Management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee")
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @JoinColumns({
            @JoinColumn(name="destIdFk", referencedColumnName="designationId")
    })
    @OneToOne Designation designation;
    private String name;
    private Integer mobileNo;
    private String address;
    private Integer postalCode;
    private String startDate;
    private String endDate;
    private int salary;
    private String status;

}

