package com.yash.airportpool.service;

import org.springframework.stereotype.Service;

@Service
public class PricingService {

    public double calculatePrice(double distance,
                                 int passengerCount,
                                 boolean peak) {

        double baseFare = 50;
        double perKmRate = 10;

        double fare = baseFare + (distance * perKmRate);

        if (peak) {
            fare *= 1.5;
        }

        double discount = fare * (0.05 * passengerCount);

        return fare - discount;
    }
}
