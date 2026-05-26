package com.tasks.todoapp.service;

import com.tasks.todoapp.dto.AuthResponse;
import com.tasks.todoapp.dto.LoginRequest;
import com.tasks.todoapp.dto.RegisterRequest;
import com.tasks.todoapp.entity.User;
import com.tasks.todoapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public AuthResponse register(RegisterRequest request){
    validateCredentials(request.getUserId(), request.getPassword());
    if (userRepository.findByUserId(request.getUserId()).isPresent()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
    }

    User user = new User();
    user.setUserId(request.getUserId());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    User savedUser = userRepository.save(user);
    return new AuthResponse(savedUser.getId(), savedUser.getUserId(), "User registered successfully");
  }

  public AuthResponse login(LoginRequest request) {
    validateCredentials(request.getUserId(), request.getPassword());
    User user = userRepository.findByUserId(request.getUserId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid user id or password"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid user id or password");
    }

    return new AuthResponse(user.getId(), user.getUserId(), "Login successful");
  }

  private void validateCredentials(String userId, String password) {
    if (userId == null || userId.isBlank()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id is required");
    }
    if (password == null || password.isBlank()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is required");
    }
  }
}
