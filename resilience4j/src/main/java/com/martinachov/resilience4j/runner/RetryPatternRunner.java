package com.martinachov.resilience4j.runner;

import com.martinachov.resilience4j.model.Flight;
import com.martinachov.resilience4j.model.SearchRequest;
import com.martinachov.resilience4j.service.RetryService;
import com.martinachov.resilience4j.service.failures.FailNTimes;
import com.martinachov.resilience4j.service.failures.FailNTimesCheckedException;
import com.martinachov.resilience4j.service.mock.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RetryPatternRunner {

    private final RetryService service;

    public void run() {
        System.out.println("Running retry examples");
        System.out.println("------------------------- basicExample ---------------------------------------------");
        basicExample();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("------------------------- checkedExceptionExample ---------------------------------------------");
        checkedExceptionExample();
        System.out.println("----------------------------------------------------------------------");
    }

    private void basicExample() {
        service.setPotentialFailure(new FailNTimes(3));
        SearchRequest request = new SearchRequest("NYC", "LAX", "07/31/2021");
        List<Flight> flights = service.basicExample(request);
        System.out.println(flights);
    }

    private void checkedExceptionExample() {
        SearchRequest request = new SearchRequest("NYC", "LAX", "07/31/2021");
        service.setPotentialFailureCheckedException(new FailNTimesCheckedException(2));

        try {
            List<Flight> flights = service.searchFlightsThrowingException(request);
            System.out.println(flights);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
