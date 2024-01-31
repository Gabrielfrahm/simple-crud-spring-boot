package com.github.gabrielFrahm.cars.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginData {

  @NotEmpty
  private String email;

  @NotEmpty
  private String password;


  @Getter
  @AllArgsConstructor
  public static class UserLoginDataResponse {
    private String token;
  }
}