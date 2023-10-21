package com.example.todolist.repositories;

import com.example.todolist.entities.ToDoItem;
import com.example.todolist.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
