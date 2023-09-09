package com.martinachov.resilience4j.service.failures;

public interface PotentialFailure {
    boolean occur();
}
