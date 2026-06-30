package com.airtribe.ridewise.model;

import java.util.Objects;

/**
 * Represents a ride booked by a rider.
 *
 * Demonstrates composition by owning a FareReceipt.
 */
public class Ride {

    private final String rideId;
    private final Rider rider;

    private Driver driver;

    private final String pickupLocation;
    private final String destination;

    private final double distance;

    private RideStatus rideStatus;

    private FareReceipt fareReceipt;

    public Ride(String rideId,
                Rider rider,
                String pickupLocation,
                String destination,
                double distance) {

        this.rideId = Objects.requireNonNull(rideId);
        this.rider = Objects.requireNonNull(rider);
        this.pickupLocation = Objects.requireNonNull(pickupLocation);
        this.destination = Objects.requireNonNull(destination);

        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be greater than zero.");
        }

        this.distance = distance;
        this.rideStatus = RideStatus.REQUESTED;
    }

    public String getRideId() {
        return rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public FareReceipt getFareReceipt() {
        return fareReceipt;
    }

    /**
     * Assigns a driver to this ride.
     */
    public void assignDriver(Driver driver) {

        if (rideStatus != RideStatus.REQUESTED) {
            throw new IllegalStateException(
                    "Driver can only be assigned to a requested ride.");
        }

        this.driver = Objects.requireNonNull(driver);
        this.rideStatus = RideStatus.DRIVER_ASSIGNED;
    }

    /**
     * Starts the ride.
     */
    public void startRide() {

        if (rideStatus != RideStatus.DRIVER_ASSIGNED) {
            throw new IllegalStateException(
                    "Ride can only start after driver assignment.");
        }

        rideStatus = RideStatus.STARTED;
    }

    /**
     * Completes the ride.
     */
    public void completeRide(FareReceipt fareReceipt) {

        if (rideStatus != RideStatus.STARTED) {
            throw new IllegalStateException(
                    "Ride must be started before completion.");
        }

        this.fareReceipt = Objects.requireNonNull(fareReceipt);

        rideStatus = RideStatus.COMPLETED;
    }

    /**
     * Cancels the ride.
     */
    public void cancelRide() {

        if (rideStatus == RideStatus.COMPLETED) {
            throw new IllegalStateException(
                    "Completed ride cannot be cancelled.");
        }

        if (rideStatus == RideStatus.CANCELLED) {
            throw new IllegalStateException(
                    "Ride is already cancelled.");
        }

        rideStatus = RideStatus.CANCELLED;
    }

    @Override
    public String toString() {

        return "Ride{" +
                "rideId='" + rideId + '\'' +
                ", rider=" + rider +
                ", driver=" + driver +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", rideStatus=" + rideStatus +
                '}';
    }
}