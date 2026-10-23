package com.example.tasktracker.service;
//import com.example.tasktracker.component.TaskIdGenerator;
import com.example.tasktracker.h2.repository.Activities;
import com.example.tasktracker.h2.repository.H2repository;
import com.example.tasktracker.oracle.repository.TaskRepository;

import com.example.tasktracker.taskResponse.TaskResponse;
import org.modelmapper.ModelMapper;
import  org.springframework.stereotype.Service;
import com.example.tasktracker.oracle.repository.TaskModel;

import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final H2repository h2repository;
    private final ModelMapper modelMapper;
//    private final TaskIdGenerator taskIdGenerator;

    public TaskService(TaskRepository taskRepository,H2repository h2repository,ModelMapper modelMapper){
        this.taskRepository=taskRepository;
        this.h2repository=h2repository;
        this.modelMapper = modelMapper;
//        this.taskIdGenerator=taskIdGenerator;
    }
    public String createTask(String title){
        TaskModel task = new TaskModel();

//       task.setId(taskIdGenerator.genId());
        task.setTitle(title);
        task.setCompleted(false);

        Activities activities = new Activities();
        activities.setAction("created");


        TaskModel savedTask =  taskRepository.save(task);
        activities.setTaskId(savedTask.getId());
        h2repository.save(activities);

         return "Details got Saved";
    }
    public Iterable<TaskModel> getallTasks(){
        return taskRepository.findAll();
    }

    public Iterable<Activities> getallActivities(){return h2repository.findAll();}

    public TaskResponse getTaskbyId(Integer id){
      Optional<TaskModel> taskModel = taskRepository.findById(id);
//      TaskResponse taskResponse = new TaskResponse();
            return  modelMapper.map(taskModel, TaskResponse.class);


    }
}