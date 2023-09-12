package com.martinachov.resilience4j.service;

import com.martinachov.resilience4j.model.Flight;
import com.martinachov.resilience4j.model.SearchRequest;
import com.martinachov.resilience4j.service.mock.FlightSearchService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateLimiterService {

    private final FlightSearchService service;

    @RateLimiter(name = "basic")
    public List<Flight> basicExample(SearchRequest request) {
        return service.searchFlights(request);
    }

}
