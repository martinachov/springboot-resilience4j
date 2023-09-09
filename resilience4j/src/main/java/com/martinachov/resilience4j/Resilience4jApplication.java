package com.martinachov.resilience4j;

import com.martinachov.resilience4j.model.Flight;
import com.martinachov.resilience4j.model.SearchRequest;
import com.martinachov.resilience4j.service.mock.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Resilience4jApplication {

	private final FlightSearchService service;

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runExamples() {
		SearchRequest request = SearchRequest.builder().from("NYC").to("LAX").flightDate("09/09/2023").build();
		List<Flight> flights = service.searchFlights(request);
		System.out.println(flights);

	}
}
