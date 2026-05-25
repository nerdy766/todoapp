package com.tasks.todoapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
  private String userId;
  private String password;

}
