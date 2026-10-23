package com.example.tasktracker.controller;

import com.example.tasktracker.h2.entity.Activities;
import com.example.tasktracker.oracle.TaskModel;
import com.example.tasktracker.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String welcome(){
        return "Welocome to task tracker";
    }
    @PostMapping("/tasks")
    public String createTask(@RequestParam String title){
          return taskService.createTask(title);
    }
    @GetMapping("/tasks")
    public Iterable<TaskModel> getalltasks(){
       return taskService.getallTasks();
    }
    @GetMapping("/activities")
    public Iterable<Activities> getallactivities(){return taskService.getallActivities();}

}