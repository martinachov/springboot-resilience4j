package com.martinachov.resilience4j.controller;

import com.martinachov.resilience4j.dto.Response;
import com.martinachov.resilience4j.service.ResilienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResilienceController {

    private final ResilienceService resilienceService;

    @GetMapping(value = "/timeDelay/{delay}")
    public ResponseEntity<Response> timeDelay(@PathVariable int delay){
        String data = resilienceService.getTimeDelayData(delay);
        return ResponseEntity.ok(
                Response.builder()
                        .data(data)
                        .code(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping(value = "/error")
    public ResponseEntity<Response> error() {
        String error = resilienceService.getError();
        return ResponseEntity.ok(
                Response.builder()
                        .data(error)
                        .build());
    }
}
