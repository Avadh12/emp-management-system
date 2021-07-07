package com.example.Employee_Management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private Integer Project_id;

    @Override
    public String toString() {
        return "Task{" +
                "Task_Id=" + Task_Id +
                ", TaskDescription='" + TaskDescription + '\'' +
                ", Project_id=" + Project_id +
                '}';
    }
}

