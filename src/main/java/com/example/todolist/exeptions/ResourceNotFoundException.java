package com.example.todolist.exeptions;

public class ResourceNotFoundException extends RuntimeException{
  public ResourceNotFoundException(String resourceName, String name, String value) {
    super(String.format("%s not found with the given input data %s: %s",
        resourceName, name, value));
  }
}
