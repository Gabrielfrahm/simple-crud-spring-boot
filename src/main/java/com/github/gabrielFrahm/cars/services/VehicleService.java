package com.github.gabrielFrahm.cars.services;

import com.github.gabrielFrahm.cars.dtos.CreateVehicleData;
import com.github.gabrielFrahm.cars.models.Vehicle;
import com.github.gabrielFrahm.cars.repositories.ModelRepository;
import com.github.gabrielFrahm.cars.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {
  private final VehicleRepository vehicleRepository;
  private final ModelRepository modelRepository;

  public List<Vehicle> list() {
     return vehicleRepository.findAll();
  }

  public Vehicle getById(Long id) {
    return vehicleRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"vehicle not found"));
  }
  public Vehicle create(CreateVehicleData data){

    var model =  modelRepository.findById(data.getModelId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"model not found"));

    var newVehicle = new Vehicle(
      data.getKilometers(),
        data.getColor(),
        data.getDescription(),
        data.getYear(),
        model
    );

    vehicleRepository.save(newVehicle);
    return  newVehicle;
  }

  public Vehicle updateById(Vehicle vehicle, Long id) {
    return null;
  }

  public void deleteById(Long id) {

  }
}
