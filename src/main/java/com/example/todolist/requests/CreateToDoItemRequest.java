package com.example.todolist.requests;

import lombok.Data;

@Data
public class CreateToDoItemRequest {
  private String title;
  private String description;
}
