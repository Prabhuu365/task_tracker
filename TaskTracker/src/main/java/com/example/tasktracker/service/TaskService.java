package com.example.tasktracker.service;
//import com.example.tasktracker.component.TaskIdGenerator;
import com.example.tasktracker.h2.entity.Activities;
import com.example.tasktracker.h2.repository.H2repository;
import com.example.tasktracker.oracle.repository.TaskRepository;

import  org.springframework.stereotype.Service;
import com.example.tasktracker.oracle.TaskModel;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final H2repository h2repository;
//    private final TaskIdGenerator taskIdGenerator;

    public TaskService(TaskRepository taskRepository,H2repository h2repository){
        this.taskRepository=taskRepository;
        this.h2repository=h2repository;
//        this.taskIdGenerator=taskIdGenerator;
    }
    public String createTask(String title){
        TaskModel task = new TaskModel();

//       task.setId(taskIdGenerator.genId());
        task.setTitle(title);
        task.setCompleted(false);

        Activities activities = new Activities();
        activities.setAction("created");
        activities.setTaskId(activities.getTaskId());

        taskRepository.save(task);
        h2repository.save(activities);

         return "Details got Saved";
    }
    public Iterable<TaskModel> getallTasks(){
        return taskRepository.findAll();
    }

    public Iterable<Activities> getallActivities(){return h2repository.findAll();}
}