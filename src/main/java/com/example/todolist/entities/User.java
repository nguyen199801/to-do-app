package com.example.todolist.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "to_do_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long uid;
  private String firstName;
  private String lastName;
  @Column(name = "user_age")
  private Integer age;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<ToDoItem> todoItems;
}
