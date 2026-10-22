package com.example.tasktracker.service;
//import com.example.tasktracker.component.TaskIdGenerator;
import com.example.tasktracker.oracle.repository.TaskRepository;

import  org.springframework.stereotype.Service;
import com.example.tasktracker.oracle.TaskModel;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
//    private final TaskIdGenerator taskIdGenerator;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
//        this.taskIdGenerator=taskIdGenerator;
    }
    public String createTask(String title){
        TaskModel task = new TaskModel();

//       task.setId(taskIdGenerator.genId());
        task.setTitle(title);
        task.setCompleted(false);

        taskRepository.save(task);
         return "Details got Saved";
    }
    public Iterable<TaskModel> getallTasks(){
        return taskRepository.findAll();
    }
}