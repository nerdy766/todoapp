package com.tasks.todoapp.repository;

import com.tasks.todoapp.entity.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task,Long>{

  Pageable task(String task);

  List<Task> findByTaskListId(Long listId);

}
