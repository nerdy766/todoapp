
package com.tasks.todoapp.controller;

import com.tasks.todoapp.entity.Task;
import com.tasks.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TaskController {
  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }
  @PostMapping("/lists/{listId}/tasks")
  public Task createTask(@RequestBody Task task, @PathVariable Long listId){
    return taskService.createTask(task,listId);
  }

//  @GetMapping
//  public List<Task> getAllTask(){
//    return taskService.getAllTasks();
//  }
//  @GetMapping("/{id}/tasks")
//    public Task getTaskById(@PathVariable Long id){
//      return taskService.getTaskById(id);
//    }

  @PutMapping("/tasks/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id){
      return taskService.updateTask(task,id);
    }
  @DeleteMapping("/tasks/{id}")
  public String deleteTask(@PathVariable Long id){
     taskService.deleteTask(id);
     return "Deleted Successfully";
  }
  @GetMapping("/lists/{listId}/tasks")
    public List<Task>  getTaskByListId(@PathVariable Long listId){
      return taskService.getTaskByListId(listId);
  }

}
