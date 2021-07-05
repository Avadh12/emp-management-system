package com.example.Employee_Management.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskAllotmentCreateRequest {

    private Integer Emp_id;
    private Integer Ranking;
    private String feedback;
    private String status;
    private String Start_date;
    private String End_date;
}