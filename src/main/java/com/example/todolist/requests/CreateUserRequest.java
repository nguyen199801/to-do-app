package com.example.todolist.requests;

import lombok.Data;

@Data
public class CreateUserRequest {
  private String firstName;
  private String lastName;
  private int age;
}
