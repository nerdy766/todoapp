package com.tasks.todoapp.repository;

import com.tasks.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{
  Optional<User> findByUserId(String userId);
}
