package com.tasks.todoapp.repository;

import com.tasks.todoapp.entity.Task;
import com.tasks.todoapp.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskListRepository extends JpaRepository <TaskList, Long> {

}
