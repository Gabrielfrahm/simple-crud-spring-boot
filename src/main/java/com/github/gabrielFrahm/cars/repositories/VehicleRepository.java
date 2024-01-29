package com.github.gabrielFrahm.cars.repositories;

import com.github.gabrielFrahm.cars.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
