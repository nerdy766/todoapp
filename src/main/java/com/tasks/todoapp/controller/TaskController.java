
package com.tasks.todoapp.controller;

import com.tasks.todoapp.entity.Task;
import com.tasks.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/tasks")
public class TaskController {
  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }
  @PostMapping
  public Task creatTask(@RequestBody Task task){
    return taskService.createTask(task);
  }
  @GetMapping
  public List<Task> getAllTask(){
    return taskService.getAllTasks();
  }
  @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
      return taskService.getTaskById(id);
    }
  @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id){
      return taskService.updateTask(task,id);
    }
  @DeleteMapping("/{id}")
  public String deleteTask(@PathVariable Long id){
     taskService.deleteTask(id);
     return "Deleted Successfully";
  }
}
