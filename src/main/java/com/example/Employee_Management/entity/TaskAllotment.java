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
@Entity()
public class TaskAllotment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskAllotedId;
    @JoinColumn(name="taskIdFk", referencedColumnName="taskId")
    @OneToOne Task task;

    @JoinColumn(name="empIdFk_1", referencedColumnName="empId")
    @OneToOne Employee employee;

    private Integer ranking;  // may be 1,2,3,....
    private String feedback;
    private String status;
    private String startDate;
    private String endDate;

}
