package com.martinachov.resilience4j.service.failures;

public interface PotentialFailureCheckedException {
    boolean occur() throws Exception;
}
