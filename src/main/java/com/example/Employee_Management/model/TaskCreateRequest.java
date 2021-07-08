package com.example.Employee_Management.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskCreateRequest {

    private Integer projectId;
    private String taskDescription;
}
