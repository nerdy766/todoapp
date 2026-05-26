package com.tasks.todoapp.controller;

import com.tasks.todoapp.dto.AuthResponse;
import com.tasks.todoapp.dto.LoginRequest;
import com.tasks.todoapp.dto.RegisterRequest;
import com.tasks.todoapp.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/register")
  public AuthResponse register(@RequestBody RegisterRequest request) {
    return authService.register(request);
  }

  @PostMapping("/login")
  public AuthResponse login(@RequestBody LoginRequest request) {
    return authService.login(request);
  }
}
