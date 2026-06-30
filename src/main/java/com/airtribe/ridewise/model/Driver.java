package com.airtribe.ridewise.model;

/**
 * Represents a driver registered in the RideWise system.
 *
 * A driver maintains their current location, availability,
 * and completed ride statistics.
 */
public class Driver {

    private final String driverId;
    private final String name;

    private String currentLocation;
    private boolean available;
    private int completedRideCount;

    public Driver(String driverId,
                  String name,
                  String currentLocation) {

        this.driverId = driverId;
        this.name = name;
        this.currentLocation = currentLocation;
        this.available = true;
        this.completedRideCount = 0;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getCompletedRideCount() {
        return completedRideCount;
    }

    public void updateLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void updateAvailability(boolean available) {
        this.available = available;
    }

    public void incrementCompletedRideCount() {
        completedRideCount++;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", name='" + name + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", available=" + available +
                ", completedRideCount=" + completedRideCount +
                '}';
    }
}