package com.airtribe.ridewise.model;

/**
 * Represents a rider registered in RideWise.
 */
public class Rider {

    private final String riderId;
    private final String name;
    private final String pickupLocation;

    public Rider(String riderId, String name, String pickupLocation) {
        this.riderId = riderId;
        this.name = name;
        this.pickupLocation = pickupLocation;
    }

    public String getRiderId() {
        return riderId;
    }

    public String getName() {
        return name;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "riderId='" + riderId + '\'' +
                ", name='" + name + '\'' +
                ", pickupLocation='" + pickupLocation + '\'' +
                '}';
    }
}