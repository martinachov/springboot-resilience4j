package com.martinachov.resilience4j.service.failures;

public class NoFailure implements PotentialFailure {
    @Override
    public boolean occur() {
        return false;
    }
}
