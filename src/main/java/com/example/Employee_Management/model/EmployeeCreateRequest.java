package com.example.Employee_Management.model;

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
    private String StartDate;
    private String EndDate;
    private Integer Salary;
    private String Status;

}