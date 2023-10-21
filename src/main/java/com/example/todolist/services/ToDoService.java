package com.example.todolist.services;

import com.example.todolist.entities.ToDoItem;
import com.example.todolist.entities.User;
import com.example.todolist.exeptions.ResourceNotFoundException;
import com.example.todolist.repositories.ToDoItemRepository;
import com.example.todolist.repositories.UserRepository;
import com.example.todolist.requests.CreateToDoItemRequest;
import com.example.todolist.requests.CreateUserRequest;
import com.example.todolist.responses.ToDoItemResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToDoService {
  ToDoItemRepository toDoItemRepository;
  UserRepository userRepository;
  ModelMapper modelMapper;

  public User createUser(CreateUserRequest createUserRequest) {
    User user = modelMapper.map(createUserRequest, User.class);
    return userRepository.save(user);
  }

  public ToDoItem createToDoItemByUid(Long uid, CreateToDoItemRequest createToDoItemRequest) {
    User user = userRepository.findByUid(uid)
        .orElseThrow(() -> new ResourceNotFoundException("User", "uid", String.valueOf(uid)));
    ToDoItem toDoItem = modelMapper.map(createToDoItemRequest, ToDoItem.class);
    toDoItem.setUser(user);
    return toDoItemRepository.save(toDoItem);
  }

  public List<ToDoItemResponse> getToDoItemByUid(Long uid) {
    User user = userRepository.findByUid(uid)
        .orElseThrow(() -> new ResourceNotFoundException("User", "uid", String.valueOf(uid)));
    List<ToDoItemResponse> toDoItemResponses = user.getTodoItems()
        .stream().map(toDoItem -> modelMapper.map(toDoItem, ToDoItemResponse.class))
        .collect(Collectors.toList());
    return toDoItemResponses;
  }
}
