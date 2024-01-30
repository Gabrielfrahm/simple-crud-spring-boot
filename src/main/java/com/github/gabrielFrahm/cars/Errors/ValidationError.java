package com.github.gabrielFrahm.cars.Errors;

import lombok.Getter;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
@Getter
public class ValidationError {
  private String field;
  private String message;

  public  ValidationError(final FieldError error) {
    this.field = error.getField();
    this.message = error.getDefaultMessage();
  }

  public static List<ValidationError> of(MethodArgumentNotValidException exception){
    return exception.getBindingResult()
        .getAllErrors()
        .stream()
        .map((error) -> (new ValidationError((org.springframework.validation.FieldError) error)))
        .toList();
  }
}
