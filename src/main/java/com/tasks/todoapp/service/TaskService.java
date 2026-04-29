package com.tasks.todoapp.service;

import com.tasks.todoapp.entity.Task;
import com.tasks.todoapp.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {
  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }
  public Task createTask(Task task){
    return taskRepository.save(task);
  }
  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }
  public Task getTaskById(Long id){
    return taskRepository.findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found with id:" + id));
  }
  public void deleteTask(Long id) {
    taskRepository.deleteById(id);
  }
  public Task updateTask(Task updatedTask, Long id){
    Task existing_task = taskRepository.findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Task Not found with id:" +id));
    existing_task.setTask(updatedTask.getTask());
    existing_task.setDeadline(updatedTask.getDeadline());
    existing_task.setCompleted(updatedTask.isCompleted());
    return taskRepository.save(existing_task);
  }

}
