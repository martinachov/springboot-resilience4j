package com.martinachov.resilience4j.service.mock;

import com.martinachov.resilience4j.model.Flight;
import com.martinachov.resilience4j.model.SearchRequest;
import com.martinachov.resilience4j.service.failures.NoFailure;
import com.martinachov.resilience4j.service.failures.PotentialFailure;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * MOCK API Remote Service to search flights
 */
@Service
public class FlightSearchService {

    PotentialFailure potentialFailure = new NoFailure();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss SSS");

    public List<Flight> searchFlights(SearchRequest request) {
        System.out.println("Searching for flights; current time = " + LocalDateTime.now().format(formatter));

        potentialFailure.occur();

        List<Flight> flights = Arrays.asList(
                new Flight("XY 765", request.getFlightDate(), request.getFrom(), request.getTo()),
                new Flight("XY 781", request.getFlightDate(), request.getFrom(), request.getTo()),
                new Flight("XY 732", request.getFlightDate(), request.getFrom(), request.getTo()),
                new Flight("XY 746", request.getFlightDate(), request.getFrom(), request.getTo())
        );

        System.out.println("Flight search successful");
        return flights;
    }

    public void setPotentialFailure(PotentialFailure potentialFailure) {
        this.potentialFailure = potentialFailure;
    }
}
