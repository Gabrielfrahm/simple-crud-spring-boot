package com.github.gabrielFrahm.cars.controllers;


import com.github.gabrielFrahm.cars.dtos.CreateVehicleData;
import com.github.gabrielFrahm.cars.dtos.UpdateVehicleData;
import com.github.gabrielFrahm.cars.dtos.VehicleData;
import com.github.gabrielFrahm.cars.models.*;

import com.github.gabrielFrahm.cars.pagination.Page;
import com.github.gabrielFrahm.cars.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
    @Autowired
    private final VehicleService  vehicleService;

    @GetMapping
    public Page<VehicleData> index(Pageable pageable){
        var page = vehicleService.find(pageable);
        return page.map(VehicleData::new);
    }

    @GetMapping("/{id}")
    public VehicleData show(@PathVariable("id") Long id){
        var vehicle = vehicleService.getById(id);
        return new VehicleData(vehicle);
    }

    @PostMapping
    public VehicleData create(@RequestBody @Validated CreateVehicleData data){
        var vehicle = vehicleService.create(data);
        return  new VehicleData(vehicle);
    }

    @PutMapping("/{id}")
    public VehicleData update(@PathVariable("id") Long id, @RequestBody @Validated UpdateVehicleData vehicle){
        var vehicleUpdated = vehicleService.updateById(vehicle, id);
        return new VehicleData(vehicleUpdated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id, Vehicle vehicle){
        vehicleService.deleteById(id);
    }
}
