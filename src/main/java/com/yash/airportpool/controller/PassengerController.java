package com.yash.airportpool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.yash.airportpool.model.Passenger;
import com.yash.airportpool.repository.PassengerRepository;
import com.yash.airportpool.service.PoolingService;

@RestController
@RequestMapping("/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerRepository passengerRepository;
    private final PoolingService poolingService;

    @PostMapping("/request")
    public String requestRide(@RequestBody Passenger passenger) {

        passenger.setStatus("REQUESTED");
        Passenger saved = passengerRepository.save(passenger);

        var ride = poolingService.assignPassenger(saved);

        if (ride != null) {
            return "Assigned to Ride ID: " + ride.getId();
        }

        return "No Ride Found";
    }
}
