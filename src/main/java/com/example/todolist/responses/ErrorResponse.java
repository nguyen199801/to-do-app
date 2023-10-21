package com.example.todolist.responses;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {
  private String path;
  private HttpStatus statusCode;
  private String message;
  private LocalDateTime time;
}
