package com.yash.airportpool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.airportpool.model.*;
import com.yash.airportpool.repository.*;

@Service
@RequiredArgsConstructor
public class RideService {

    private final RideRepository rideRepository;
    private final RidePassengerMappingRepository mappingRepository;
    private final PassengerRepository passengerRepository;

    @Transactional
    public void cancelPassenger(Long rideId, Long passengerId) {

        RidePool ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));

        ride.setAvailableSeats(
                ride.getAvailableSeats() + passenger.getSeatRequired());

        ride.setCurrentLuggage(
                ride.getCurrentLuggage() - passenger.getLuggageCount());

        passenger.setStatus("CANCELLED");

        rideRepository.save(ride);
        passengerRepository.save(passenger);
    }
}
