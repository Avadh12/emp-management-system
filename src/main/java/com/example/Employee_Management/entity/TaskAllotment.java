package com.example.Employee_Management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskAllotment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer TaskAllotedId;
//   @MapsId("task_ID")
  //  @JoinColumns({


 //   })
    @JoinColumn(name="task_id_fk", referencedColumnName="Task_Id")
    @OneToOne Task task;
  //  private Integer Task_Id;
  //  @MapsId("userId")
 //   @JoinColumns({


   // })
            @JoinColumn(name="emp_id_fk_1", referencedColumnName="Emp_id")
    @OneToOne Employee employee;
 //   private Integer Emp_id;
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
    //            ", Task_Id=" + Task_Id +
     //           ", Emp_id=" + Emp_id +
                ", Ranking=" + Ranking +
                ", feedback='" + feedback + '\'' +
                ", status='" + status + '\'' +
                ", Start_date='" + Start_date + '\'' +
                ", End_date='" + End_date + '\'' +
                '}';
    }
}
