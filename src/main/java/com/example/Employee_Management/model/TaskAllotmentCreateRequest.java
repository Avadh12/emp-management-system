package com.example.Employee_Management.model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TaskAllotmentCreateRequest {
    private  Integer taskId;
    private long empId;
    private Integer ranking;
    private String feedback;
    private String status;
    private String startDate;
    private String endDate;
}