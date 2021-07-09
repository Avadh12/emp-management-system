package com.example.Employee_Management.model;
import com.example.Employee_Management.entity.Designation;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmployeeCreateRequest {
    private String name;
    private Integer destId;
    private Integer mobileNo;
    private String address;
    private Integer postalCode;
    private String startDate;
    private String endDate;
    private Integer salary;
    private String status;
    private Designation designation;

}