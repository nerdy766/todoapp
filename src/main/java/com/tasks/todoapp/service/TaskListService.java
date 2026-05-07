package com.tasks.todoapp.service;

import com.tasks.todoapp.entity.Task;
import com.tasks.todoapp.entity.TaskList;
import com.tasks.todoapp.entity.User;
import com.tasks.todoapp.repository.TaskListRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskListService {
  private final TaskListRepository taskListRepository;
  private final UserService userService;
  public TaskListService(TaskListRepository taskListRepository, UserService userService) {
    this.taskListRepository = taskListRepository;
    this.userService = userService;
  }

  public TaskList creatList(TaskList taskList, Long userId){
    User user = userService.getUserById(userId);
    taskList.setUser(user);
    return taskListRepository.save(taskList);
  }

  public List<TaskList> getAllList(){
    return taskListRepository.findAll();
  }
  public TaskList getListById(Long listId){
    return taskListRepository.findById(listId)
            .orElseThrow(()-> new RuntimeException("Task List not Found"));
  }
  public void deleteList(Long listId){
    TaskList list = taskListRepository.findById(listId)
            .orElseThrow(()-> new RuntimeException("List doesn't exist"));
    taskListRepository.deleteById(listId);

  }
}
