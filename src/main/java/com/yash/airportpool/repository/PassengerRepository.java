package com.yash.airportpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yash.airportpool.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
