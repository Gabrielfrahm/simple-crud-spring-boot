package com.github.gabrielFrahm.cars.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kilometers")
    private Integer kilometers;

    @Column(name = "color", length = 150)
    private String color;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "available")
    private boolean available;
    @Column(name = "year")
    private Integer year;

    @JoinColumn(name = "model_id")
    @ManyToOne
    private Model model;

    @ManyToMany
    @JoinTable(
        name = "vehicle_optional",
        joinColumns = {@JoinColumn(name = "vehicle_id")},
        inverseJoinColumns = {@JoinColumn(name = "optional_id")}
    )
    private List<Optional> optionals;

  public Vehicle(Integer kilometers, String color, String description, Integer year, Model model) {
    this.kilometers = kilometers;
    this.color = color;
    this.description = description;
    this.available = true;
    this.year = year;
    this.model = model;
    this.optionals = List.of();
  }
}
