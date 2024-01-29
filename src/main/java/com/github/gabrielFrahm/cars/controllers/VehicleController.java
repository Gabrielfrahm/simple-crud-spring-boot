package com.github.gabrielFrahm.cars.controllers;


import com.github.gabrielFrahm.cars.dtos.CreateVehicleData;
import com.github.gabrielFrahm.cars.models.*;

import com.github.gabrielFrahm.cars.repositories.VehicleRepository;
import com.github.gabrielFrahm.cars.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
    @Autowired
    private final VehicleService  vehicleService;

    @GetMapping
    public List<Vehicle> index(){
        return vehicleService.list();
    }

    @GetMapping("/{id}")
    public Vehicle show(@PathVariable("id") Long id){
        return vehicleService.getById(id);
    }

    @PostMapping
    public Vehicle create(CreateVehicleData vehicle){
        return vehicleService.create(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable("id") Long id, Vehicle vehicle){
        return vehicleService.updateById(vehicle, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id, Vehicle vehicle){
        vehicleService.deleteById(id);
    }
}
