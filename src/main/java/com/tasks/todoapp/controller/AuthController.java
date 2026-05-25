package com.tasks.todoapp.controller;

import com.tasks.todoapp.dto.RegisterRequest;
import com.tasks.todoapp.entity.User;
import com.tasks.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
public class AuthController {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public String register(@RequestBody RegisterRequest request) {
    if (userRepository.findByUserId(request.getUserId()).isPresent()) {
      return "User already exists";
    }

    User user = new User();
    user.setUserId(request.getUserId());
    user.setPassword(
            passwordEncoder.encode(request.getPassword()));
    userRepository.save(user);
    return "User registered successfully";

  }
}