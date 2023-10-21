package com.example.todolist.exeptions;

import com.example.todolist.responses.ErrorResponse;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGeneralException
      (Exception exception, WebRequest webRequest) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setMessage(exception.getMessage());
    errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
    errorResponse.setPath(webRequest.getDescription(false));
    errorResponse.setTime(LocalDateTime.now());
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleResourceNotFoundException
      (ResourceNotFoundException exception, WebRequest webRequest) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setMessage(exception.getMessage());
    errorResponse.setStatusCode(HttpStatus.BAD_REQUEST);
    errorResponse.setPath(webRequest.getDescription(false));
    errorResponse.setTime(LocalDateTime.now());
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
