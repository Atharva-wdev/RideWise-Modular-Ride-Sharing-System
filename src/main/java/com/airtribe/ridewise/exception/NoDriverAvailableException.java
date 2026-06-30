package com.airtribe.ridewise.exception;

/**
 * Thrown when no suitable driver is available
 * for the requested ride.
 */
public class NoDriverAvailableException extends RuntimeException {

    public NoDriverAvailableException(String message) {
        super(message);
    }
}