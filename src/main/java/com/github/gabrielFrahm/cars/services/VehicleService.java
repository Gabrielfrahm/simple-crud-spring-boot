package com.github.gabrielFrahm.cars.services;

import com.github.gabrielFrahm.cars.dtos.CreateVehicleData;
import com.github.gabrielFrahm.cars.models.Vehicle;
import com.github.gabrielFrahm.cars.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {
  private final VehicleRepository repository;

  public List<Vehicle> list() {
     return repository.findAll();
  }

  public Vehicle getById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("vehicle not found"));
  }
  public Vehicle create(CreateVehicleData data){
//    var newVehicle = new Vehicle(
//      data.getKilometers(),
//        data.getColor(),
//        data.getDescription(),
//        data.getYear(),
//        data.getModelId()
//    );
    return  null;
  }

  public Vehicle updateById(Vehicle vehicle, Long id) {
    return null;
  }

  public void deleteById(Long id) {

  }
}
