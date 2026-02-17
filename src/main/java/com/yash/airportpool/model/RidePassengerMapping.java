package com.yash.airportpool.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class RidePassengerMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rideId;
    private Long passengerId;
}
