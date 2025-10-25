package com.example.crud_app_practice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.crud_app_practice.response_setups.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // any uncaught exception
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<Object>> handleGlobalException(Exception ex) {
    ApiResponse<Object> response = new ApiResponse<>(false, ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // handle specfic entry not found cases in database 
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException ex) {
    ApiResponse<Object> response = new ApiResponse<>(true, ex.getMessage(), null);
    return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
  }
}
