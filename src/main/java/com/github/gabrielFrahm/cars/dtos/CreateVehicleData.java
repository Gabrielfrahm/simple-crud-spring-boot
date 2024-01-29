package com.github.gabrielFrahm.cars.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateVehicleData {
  private Integer kilometers;
  private String color;
  private String description;
  private Integer year;
  private Long ModelId;
}
