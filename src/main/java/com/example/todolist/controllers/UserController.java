package com.example.todolist.controllers;

import com.example.todolist.entities.User;
import com.example.todolist.requests.CreateUserRequest;
import com.example.todolist.services.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UserController {
  ToDoService toDoService;

  @PostMapping()
  public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
    User user = toDoService.createUser(createUserRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}
