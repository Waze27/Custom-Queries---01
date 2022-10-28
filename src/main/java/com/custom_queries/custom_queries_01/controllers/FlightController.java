package com.custom_queries.custom_queries_01.controllers;

import com.custom_queries.custom_queries_01.entities.Flight;
import com.custom_queries.custom_queries_01.entities.Status;
import com.custom_queries.custom_queries_01.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @PostMapping("")
    public void generatesFlights() {
        Random random = new Random();
        for (int i = 0; i < 50; ++i) {
            Flight flight = new Flight();
            String randomString = random.ints(30, 100, 217)
                    .collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append)
                    .toString();
            flight.setDescription(randomString + " " + randomString + " " + randomString);
            flight.setFromAirport(randomString);
            flight.setToAirport(randomString);
            flight.setStatus(Status.ONTIME);
            flightRepository.save(flight);
        }
    }

    @GetMapping("")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}

