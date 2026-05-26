package com.tasks.todoapp.service;

import com.tasks.todoapp.entity.TaskList;
import com.tasks.todoapp.entity.User;
import com.tasks.todoapp.repository.TaskListRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class TaskListService {
  private final TaskListRepository taskListRepository;
  private final UserService userService;
  public TaskListService(TaskListRepository taskListRepository, UserService userService) {
    this.taskListRepository = taskListRepository;
    this.userService = userService;
  }

  public TaskList createList(TaskList taskList, Long userId){
    User user = userService.getUserById(userId);
    taskList.setUser(user);
    return taskListRepository.save(taskList);
  }

  public List<TaskList> getAllList(){
    return taskListRepository.findAll();
  }
  public TaskList getListById(Long listId){
    return taskListRepository.findById(listId)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task list not found with id: " + listId));
  }
  public TaskList updateList(TaskList updatedList, Long listId){
    TaskList existingList = getListById(listId);
    existingList.setName(updatedList.getName());
    existingList.setCreatedAt(updatedList.getCreatedAt());
    return taskListRepository.save(existingList);
  }
  public void deleteList(Long listId){
    getListById(listId);
    taskListRepository.deleteById(listId);

  }
}
