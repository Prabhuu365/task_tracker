package com.example.tasktracker.oracle.repository;

// Make sure to put under same package as the oracle repository

//import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskModel {
    @Id
    @SequenceGenerator(
            name = "task_model_generator",
            sequenceName = "task_model_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_model_generator"
    )
    private Integer id;
    private String title;
    private boolean completed;

//    public void setId(Integer id){
//        this.id=id;
//    }
//    public void setTitle(String title){this.title=title;}
//    public void  setCompleted(boolean completed){this.completed=completed;}
//
//    public long getId(){return id;}
//
//    public String getTitle() {
//        return title;
//    }
//
//    public boolean isCompleted() {
//        return completed;
//    }
}