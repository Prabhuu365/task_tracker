package com.example.tasktracker.controller;

import com.example.tasktracker.h2.repository.Activities;
import com.example.tasktracker.oracle.repository.TaskModel;
import com.example.tasktracker.service.TaskService;
import com.example.tasktracker.taskResponse.TaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable("id") Integer id){
       TaskResponse taskResponse = taskService.getTaskbyId(id);
       return   ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

}