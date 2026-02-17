package com.yash.airportpool.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double pickupLat;
    private double pickupLng;

    private double dropLat;
    private double dropLng;

    private int luggageCount;
    private int seatRequired;

    private double detourToleranceKm;

    private String status;
}
