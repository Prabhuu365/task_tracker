package com.example.tasktracker.h2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Activities")
public class Activities{
    @Id
    @SequenceGenerator(
            name = "activities_sequence_generator",
            sequenceName = "activities_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "activities_sequence_generator" )
    Integer id;
    @Column(nullable = false)
    private Integer taskId;

    @Column(nullable = false)
    private String action;


}
