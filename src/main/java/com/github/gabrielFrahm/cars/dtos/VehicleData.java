package com.github.gabrielFrahm.cars.dtos;

import com.github.gabrielFrahm.cars.models.Manufacturer;
import com.github.gabrielFrahm.cars.models.Model;
import com.github.gabrielFrahm.cars.models.Optional;
import com.github.gabrielFrahm.cars.models.Vehicle;
import lombok.Getter;

import java.util.List;

@Getter
public class VehicleData {
  private  Long id;

  private Integer kilometers;

  private String color;

  private String description;

  private boolean available;

  private Integer year;

  private VehicleModel model;

  private List<VehicleOptional> optionals;


  public VehicleData(Vehicle vehicle) {
    this.id = vehicle.getId();
    this.kilometers = vehicle.getKilometers();
    this.color = vehicle.getColor();
    this.description = vehicle.getDescription();
    this.available = vehicle.isAvailable();
    this.year = vehicle.getYear();
    this.model = new VehicleModel(vehicle.getModel());
    this.optionals = vehicle.getOptionals().stream().map(VehicleOptional::new).toList();
  }

  @Getter
  public static class VehicleModel {
    private final Long id;
    private final String Name;
    private final VehicleManufacturer manufacturer;

    public VehicleModel(Model model) {
      this.id = model.getId();
      this.Name = model.getName();
      this.manufacturer = new VehicleManufacturer(model.getManufacturer());
    }
  }

  @Getter
  public static class VehicleManufacturer {
    private final Long id;
    private final String Name;

    public VehicleManufacturer(Manufacturer manufacturer) {
      this.id = manufacturer.getId();
      this.Name = manufacturer.getName();
    }
  }

  @Getter
  public static class VehicleOptional {
    private final Long id;
    private final String Name;

    public VehicleOptional(Optional optional) {
      this.id = optional.getId();
      this.Name = optional.getName();
    }
  }
}
