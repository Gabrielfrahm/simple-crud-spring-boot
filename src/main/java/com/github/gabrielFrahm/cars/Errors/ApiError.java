package com.github.gabrielFrahm.cars.Errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.Collection;

@Getter
public class ApiError {
  private String message;
  private Integer status;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Collection<ValidationError> errors;

  public ApiError(HttpStatusCode status, Collection<ValidationError> errors) {
    this.message = "check the 'errors' property for more details";
    this.status = status.value();
    this.errors = errors;
  }

  public ApiError(String message, HttpStatusCode status) {
    this.message = message;
    this.status = status.value();
    this.errors = null;
  }
}
