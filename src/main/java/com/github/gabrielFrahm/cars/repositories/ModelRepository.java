package com.github.gabrielFrahm.cars.repositories;

import com.github.gabrielFrahm.cars.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
