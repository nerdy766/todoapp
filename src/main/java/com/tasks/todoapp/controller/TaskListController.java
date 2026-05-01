package com.tasks.todoapp.controller;

import com.tasks.todoapp.entity.TaskList;
import com.tasks.todoapp.service.TaskListService;
import com.tasks.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class TaskListController {
  private final TaskListService taskListService;

  public TaskListController(TaskListService taskListService) {
    this.taskListService = taskListService;
  }

  @GetMapping()
  public List<TaskList> getAllList(){
    return taskListService.getAllList();
  }
  @PostMapping
  public TaskList creatList(@RequestBody TaskList taskList){
    return taskListService.creatList(taskList);
  }
  @DeleteMapping("/{listId}")
  public void deleteList(@PathVariable Long listId){
    taskListService.deleteList(listId);
  }
}
