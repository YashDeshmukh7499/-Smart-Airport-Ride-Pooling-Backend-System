package com.yash.airportpool.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class RidePool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalSeats;
    private int availableSeats;

    private int totalLuggageCapacity;
    private int currentLuggage;

    private double baseRouteDistance;

    private String status;

    @Version
    private Long version;  // Optimistic Locking
}
