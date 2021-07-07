package com.example.Employee_Management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class TaskAllotment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer TaskAllotedId;
    private Integer Task_Id;
    private Integer Emp_id;
    private Integer Ranking;
    private String feedback;
    private String status;
  //  @JsonFormat(pattern = "yyyy-mm-dd")
    private String Start_date;

    //@JsonFormat(pattern = "yyyy-mm-dd")
    private String End_date;

    @Override
    public String toString() {
        return "TaskAllotment{" +
                "TaskAllotedId=" + TaskAllotedId +
                ", Task_Id=" + Task_Id +
                ", Emp_id=" + Emp_id +
                ", Ranking=" + Ranking +
                ", feedback='" + feedback + '\'' +
                ", status='" + status + '\'' +
                ", Start_date='" + Start_date + '\'' +
                ", End_date='" + End_date + '\'' +
                '}';
    }
}
