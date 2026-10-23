package com.example.tasktracker.oracle.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends CrudRepository<TaskModel,Integer> {
//    private final HashMap<Long, TaskModel> tasks = new HashMap<>();
//    public void save(Long key,TaskModel task){
//        tasks.put(key,task);
//    }
//    public Collection<TaskModel> getTasks(){
//       return tasks.values();
//    }
}