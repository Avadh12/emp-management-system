package com.example.Employee_Management.entity;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "taskAllotment")
public class TaskAllotment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskAllotedId;
    private Integer ranking;  // may be 1,2,3,....
    private String feedback;
    private String status;
    private String startDate;
    private String endDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "taskId")
    private Task task;

}
