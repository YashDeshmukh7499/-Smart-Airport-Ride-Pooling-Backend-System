package com.yash.airportpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yash.airportpool.model.RidePool;
import java.util.List;

public interface RideRepository extends JpaRepository<RidePool, Long> {
    List<RidePool> findByStatus(String status);
}
