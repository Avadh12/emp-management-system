package com.example.Employee_Management.entity;

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
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Task_Id;
    private String TaskDescription;
    @JoinColumn(name="project_id_fk", referencedColumnName="Project_Id")
    @OneToOne Project project;


    @Override
    public String toString() {
        return "Task{" +
                "Task_Id=" + Task_Id +
                ", TaskDescription='" + TaskDescription + '\'' +
     //           ", Project_id=" + Project_id +
                '}';
    }
}

