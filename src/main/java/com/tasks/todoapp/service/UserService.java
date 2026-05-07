package com.tasks.todoapp.service;

import com.tasks.todoapp.entity.User;
import com.tasks.todoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUserById(Long userId){
    return userRepository.findById(userId)
            .orElseThrow(()-> new RuntimeException("User not found !"));
  }
  public void deleteUser(Long userId){
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

    userRepository.delete(user);
  }
}
