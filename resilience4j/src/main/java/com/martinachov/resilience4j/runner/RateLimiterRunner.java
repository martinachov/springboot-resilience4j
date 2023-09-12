package com.martinachov.resilience4j.runner;

import com.martinachov.resilience4j.model.SearchRequest;
import com.martinachov.resilience4j.service.RateLimiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RateLimiterRunner {

    private final RateLimiterService service;

    public void run() {
        System.out.println("Running ratelimiter examples");

        System.out.println("----------------------------- basicExample ------------------------------------------");
        basicExample();
        System.out.println("-----------------------------------------------------------------------");


    }

    private void basicExample() {
        SearchRequest request = new SearchRequest("NYC", "LAX", "08/15/2021");
        for (int i=0; i<40; i++) {
            try {
                System.out.println(service.basicExample(request));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
