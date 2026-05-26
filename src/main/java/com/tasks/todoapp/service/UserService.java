package com.tasks.todoapp.service;

import com.tasks.todoapp.entity.User;
import com.tasks.todoapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUserById(Long userId){
    return userRepository.findById(userId)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + userId));
  }
  public void deleteUser(Long userId){
    User user = getUserById(userId);

    userRepository.delete(user);
  }
}
