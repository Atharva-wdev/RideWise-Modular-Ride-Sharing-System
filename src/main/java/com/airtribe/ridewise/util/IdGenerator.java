package com.airtribe.ridewise.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generates unique IDs for domain objects.
 */
public final class IdGenerator {

    private static final AtomicInteger RIDER_COUNTER = new AtomicInteger(1);
    private static final AtomicInteger DRIVER_COUNTER = new AtomicInteger(1);
    private static final AtomicInteger RIDE_COUNTER = new AtomicInteger(1);

    private IdGenerator() {
    }

    public static String generateRiderId() {
        return String.format("RID%03d", RIDER_COUNTER.getAndIncrement());
    }

    public static String generateDriverId() {
        return String.format("DRV%03d", DRIVER_COUNTER.getAndIncrement());
    }

    public static String generateRideId() {
        return String.format("RIDE%03d", RIDE_COUNTER.getAndIncrement());
    }
}