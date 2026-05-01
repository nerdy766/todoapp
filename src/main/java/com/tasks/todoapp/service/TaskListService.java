package com.tasks.todoapp.service;

import com.tasks.todoapp.entity.Task;
import com.tasks.todoapp.entity.TaskList;
import com.tasks.todoapp.repository.TaskListRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskListService {
  private final TaskListRepository taskListRepository;

  public TaskListService(TaskListRepository taskListRepository) {
    this.taskListRepository = taskListRepository;
  }
  public TaskList creatList(TaskList taskList){
    return taskListRepository.save(taskList);
  }
  public List<TaskList> getAllList(){
    return taskListRepository.findAll();
  }
//  public TaskList getListById(Long listId){
//    return taskListRepository.(listId);
//  }
  public void deleteList(Long listId){
    TaskList list = taskListRepository.findById(listId)
            .orElseThrow(()-> new RuntimeException("List doesn't exist"));
    taskListRepository.deleteById(listId);

  }
}
