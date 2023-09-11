package com.martinachov.resilience4j.service;

import com.martinachov.resilience4j.model.Flight;
import com.martinachov.resilience4j.model.SearchRequest;
import com.martinachov.resilience4j.service.failures.FailNTimes;
import com.martinachov.resilience4j.service.failures.FailNTimesCheckedException;
import com.martinachov.resilience4j.service.failures.PotentialFailure;
import com.martinachov.resilience4j.service.mock.FlightSearchService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RetryService {

    //Remote Service
    private final FlightSearchService service;

    @Retry(name = "basic", fallbackMethod = "localCacheFlightSearch")
    public List<Flight> basicExample(SearchRequest request) {
        return service.searchFlights(request);
    }

    @Retry(name = "throwingException", fallbackMethod = "localCacheFlightSearch")
    public List<Flight> searchFlightsThrowingException(SearchRequest request) throws Exception {
        return service.searchFlightsThrowingException(request);
    }

    private List<Flight> localCacheFlightSearch(SearchRequest request, RuntimeException re) {
        System.out.println("Returning search results from cache");
        return Arrays.asList(
                new Flight("XY 765", request.getFlightDate(), request.getFrom(), request.getTo()),
                new Flight("XY 781", request.getFlightDate(), request.getFrom(), request.getTo()));
    }

    public void setPotentialFailure(PotentialFailure potentialFailure) {
        service.setPotentialFailure(potentialFailure);
    }

    public void setPotentialFailureCheckedException(FailNTimesCheckedException potentialFailure) {
        service.setPotentialFailureCheckedException(potentialFailure);
    }

}
