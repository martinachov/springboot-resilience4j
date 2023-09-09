package com.martinachov.resilience4j;

import com.martinachov.resilience4j.model.Flight;
import com.martinachov.resilience4j.model.SearchRequest;
import com.martinachov.resilience4j.runner.RetryPatternRunner;
import com.martinachov.resilience4j.service.RetryService;
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

	private final RetryPatternRunner retryPatternRunner;
	public static void main(String[] args) {
		SpringApplication.run(Resilience4jApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runExamples() {
		retryPatternRunner.run();
	}
}
