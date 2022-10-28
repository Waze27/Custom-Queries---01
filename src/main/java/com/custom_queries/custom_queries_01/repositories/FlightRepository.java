package com.custom_queries.custom_queries_01.repositories;

import com.custom_queries.custom_queries_01.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
