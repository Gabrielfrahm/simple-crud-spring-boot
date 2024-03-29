package com.github.gabrielFrahm.cars.services;

import com.github.gabrielFrahm.cars.dtos.CreateVehicleData;
import com.github.gabrielFrahm.cars.dtos.UpdateVehicleData;
import com.github.gabrielFrahm.cars.models.Vehicle;
import com.github.gabrielFrahm.cars.pagination.Page;
import com.github.gabrielFrahm.cars.repositories.ModelRepository;
import com.github.gabrielFrahm.cars.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {
  private final VehicleRepository vehicleRepository;
  private final ModelRepository modelRepository;

  public Page<Vehicle> find(Pageable pageable) {
     var page = vehicleRepository.findAll(pageable);
     return  new Page<>(page);
  }

  public Vehicle getById(Long id) {
    return vehicleRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"vehicle not found"));
  }
  public Vehicle create(CreateVehicleData data){
    var model =  modelRepository.findById(data.getModelId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "model not found"));

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

  public Vehicle updateById(UpdateVehicleData data, Long id) {


    var vehicle =  vehicleRepository.findById(data.getModelId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "vehicle not found"));

    var model =  modelRepository.findById(data.getModelId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "model not found"));

    vehicle.setKilometers(data.getKilometers());
    vehicle.setColor(data.getColor());
    vehicle.setDescription(data.getDescription());
    vehicle.setYear(data.getYear());
    vehicle.setModel(model);

    vehicleRepository.save(vehicle);
    return  vehicle;
  }

  public void deleteById(Long id) {
    if(!vehicleRepository.existsById(id)){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "vehicle not found");
    }
    vehicleRepository.deleteById(id);
  }
}
