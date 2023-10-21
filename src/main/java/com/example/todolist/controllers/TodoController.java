package com.example.todolist.controllers;

import com.example.todolist.entities.ToDoItem;
import com.example.todolist.entities.User;
import com.example.todolist.requests.CreateToDoItemRequest;
import com.example.todolist.requests.CreateUserRequest;
import com.example.todolist.responses.ToDoItemResponse;
import com.example.todolist.services.ToDoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/todo", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TodoController {
  ToDoService toDoService;

  @PostMapping("/{uid}")
  public ResponseEntity<ToDoItem> createToDoItemByUid(@PathVariable Long uid,
        @RequestBody CreateToDoItemRequest createToDoItemRequest) {
    ToDoItem toDoItem = toDoService.createToDoItemByUid(uid, createToDoItemRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(toDoItem);
  }

  @GetMapping("/{uid}")
  public ResponseEntity<List<ToDoItemResponse>> getToDoItemsByUid(@PathVariable Long uid) {
    List<ToDoItemResponse> toDoItemResponses = toDoService.getToDoItemByUid(uid);
    return ResponseEntity.status(HttpStatus.CREATED).body(toDoItemResponses);
  }
}
