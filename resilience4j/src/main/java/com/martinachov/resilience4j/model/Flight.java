package com.martinachov.resilience4j.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {

    String flightNumber;
    String flightDate;
    String from;
    String to;

}
