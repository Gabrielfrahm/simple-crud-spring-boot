package com.github.gabrielFrahm.cars.configurations;

import com.github.gabrielFrahm.cars.Errors.ApiError;
import com.github.gabrielFrahm.cars.Errors.ValidationError;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
public class GlobalHandlerError {
  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<ApiError> status(ResponseStatusException exception) {
    return ResponseEntity.status(exception.getStatusCode())
        .body(new ApiError(exception.getReason(), exception.getStatusCode()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiError> validation(MethodArgumentNotValidException exception){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ApiError(HttpStatus.BAD_REQUEST, ValidationError.of(exception)));
  }
}
