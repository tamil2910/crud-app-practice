package com.example.crud_app_practice.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public  ResponseEntity<ApiResponse<Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
      errors.put(error.getField(), error.getDefaultMessage());
    });
    
    return ResponseEntity.badRequest().body(
      new ApiResponse<>(false, "Validation failed", errors)
    );
  }
}
