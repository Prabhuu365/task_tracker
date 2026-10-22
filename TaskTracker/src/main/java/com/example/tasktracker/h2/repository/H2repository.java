package com.example.tasktracker.h2.repository;


import com.example.tasktracker.h2.entity.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2repository extends JpaRepository<Activities,Integer> {
}
