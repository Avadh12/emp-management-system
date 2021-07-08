package com.example.Employee_Management.model;

import com.example.Employee_Management.entity.Designation;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeCreateRequest {
    private String Name;
    private Integer Dest_id;
    private Integer Mobile_No;
    private String Address;
    private Integer PostalCode;
    private String Start_date;
    private String End_date;
    private Integer Salary;
    private String Status;
    private Designation designation;

}