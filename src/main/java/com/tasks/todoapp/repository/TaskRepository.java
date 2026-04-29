package com.tasks.todoapp.repository;

import com.tasks.todoapp.entity.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task,Long>{

  Pageable task(String task);
}
