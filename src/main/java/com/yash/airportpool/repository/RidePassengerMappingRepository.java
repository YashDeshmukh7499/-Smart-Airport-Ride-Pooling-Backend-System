package com.yash.airportpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yash.airportpool.model.RidePassengerMapping;

public interface RidePassengerMappingRepository 
        extends JpaRepository<RidePassengerMapping, Long> {
}
