package com.yash.airportpool.dto;

import lombok.Data;

@Data
public class PassengerRequestDTO {

    private String name;

    private double pickupLat;
    private double pickupLng;

    private double dropLat;
    private double dropLng;

    private int luggageCount;
    private int seatRequired;

    private double detourToleranceKm;
}
