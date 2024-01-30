package com.github.gabrielFrahm.cars.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateVehicleData {
  @Min(value = 0, message = "value must be greater or equals than 0")
  private Integer kilometers;

  @NotEmpty
  private String color;

  @NotEmpty
  private String description;

  @NotNull
  private Integer year;

  @NotNull
  private Long ModelId;
}
