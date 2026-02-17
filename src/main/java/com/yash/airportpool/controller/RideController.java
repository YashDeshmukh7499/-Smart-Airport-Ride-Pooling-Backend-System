package com.yash.airportpool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.yash.airportpool.model.RidePool;
import com.yash.airportpool.repository.RideRepository;
import com.yash.airportpool.service.RideService;

import java.util.List;

@RestController
@RequestMapping("/rides")
@RequiredArgsConstructor
public class RideController {

    private final RideRepository rideRepository;
    private final RideService rideService;

    @GetMapping("/{id}")
    public RidePool getRide(@PathVariable Long id) {
        return rideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found"));
    }

    @PostMapping("/create")
    public RidePool createRide(@RequestBody RidePool ride) {
        ride.setStatus("ACTIVE");
        return rideRepository.save(ride);
    }

    @PostMapping("/{rideId}/cancel/{passengerId}")
    public String cancelRide(@PathVariable Long rideId,
                             @PathVariable Long passengerId) {

        rideService.cancelPassenger(rideId, passengerId);
        return "Passenger Cancelled Successfully";
    }

    @GetMapping("/active")
    public List<RidePool> activeRides() {
        return rideRepository.findByStatus("ACTIVE");
    }
}
