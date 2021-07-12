package com.example.Employee_Management.model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProjectCreateRequest {
    private String projectName;
}
