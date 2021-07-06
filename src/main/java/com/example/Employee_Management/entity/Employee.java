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
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Emp_id;

    private int Dest_id;

    private String Name;

    private Integer Mobile_No;

    private String Address;

    private Integer PostalCode;


    @JsonFormat(pattern = "yyyy-mm-dd")
    private String Start_date;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private String End_date;

    private int Salary;

    private String Status;

    @Override
    public String toString() {
        return "Employee{" +
                "Emp_id=" + Emp_id +
                ", Dest_id=" + Dest_id +
                ", Name='" + Name + '\'' +
                ", Mobile_No=" + Mobile_No +
                ", Address='" + Address + '\'' +
                ", PostalCode=" + PostalCode +
                ", Start_date='" + Start_date + '\'' +
                ", End_date='" + End_date + '\'' +
                ", Salary=" + Salary +
                ", Status='" + Status + '\'' +
                '}';
    }
}
