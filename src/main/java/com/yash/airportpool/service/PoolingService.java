package com.yash.airportpool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.airportpool.model.*;
import com.yash.airportpool.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PoolingService {

    private final RideRepository rideRepository;
    private final RidePassengerMappingRepository mappingRepository;

    @Transactional
    public RidePool assignPassenger(Passenger passenger) {

        List<RidePool> activeRides = rideRepository.findByStatus("ACTIVE");

        for (RidePool ride : activeRides) {

            if (ride.getAvailableSeats() >= passenger.getSeatRequired() &&
                (ride.getTotalLuggageCapacity() - ride.getCurrentLuggage())
                        >= passenger.getLuggageCount()) {

                ride.setAvailableSeats(
                        ride.getAvailableSeats() - passenger.getSeatRequired());

                ride.setCurrentLuggage(
                        ride.getCurrentLuggage() + passenger.getLuggageCount());

                rideRepository.save(ride);

                RidePassengerMapping mapping = new RidePassengerMapping();
                mapping.setRideId(ride.getId());
                mapping.setPassengerId(passenger.getId());
                mappingRepository.save(mapping);

                return ride;
            }
        }

        return null;
    }
}
