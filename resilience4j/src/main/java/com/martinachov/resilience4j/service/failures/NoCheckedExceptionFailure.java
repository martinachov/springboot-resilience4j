package com.martinachov.resilience4j.service.failures;

public class NoCheckedExceptionFailure implements PotentialFailureCheckedException {
    @Override
    public boolean occur() throws Exception {
        return false;
    }
}
