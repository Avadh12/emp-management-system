package com.example.Employee_Management.entity;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String projectName;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="project")
    private List<Task> task;
}
