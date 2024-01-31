package com.github.gabrielFrahm.cars.dtos;

import com.github.gabrielFrahm.cars.models.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserData {
  @NotEmpty
  @Email
  public String email;

  @NotEmpty
  @Min(5)
  public String password;

  public UserRole role;
}
