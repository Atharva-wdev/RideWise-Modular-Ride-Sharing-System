package com.airtribe.ridewise.service;

import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.FareReceipt;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.strategy.FareStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;
import com.airtribe.ridewise.util.IdGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Service responsible for the complete ride lifecycle.
 */
public class RideService {

    private final RiderService riderService;
    private final DriverService driverService;

    private RideMatchingStrategy rideMatchingStrategy;
    private FareStrategy fareStrategy;

    private final Map<String, Ride> rides = new LinkedHashMap<>();

    public RideService(RiderService riderService,
                       DriverService driverService,
                       RideMatchingStrategy rideMatchingStrategy,
                       FareStrategy fareStrategy) {

        this.riderService = Objects.requireNonNull(riderService);
        this.driverService = Objects.requireNonNull(driverService);
        this.rideMatchingStrategy = Objects.requireNonNull(rideMatchingStrategy);
        this.fareStrategy = Objects.requireNonNull(fareStrategy);
    }

    /**
     * Runtime strategy switching.
     */
    public void setRideMatchingStrategy(
            RideMatchingStrategy rideMatchingStrategy) {

        this.rideMatchingStrategy =
                Objects.requireNonNull(rideMatchingStrategy);
    }

    /**
     * Runtime strategy switching.
     */
    public void setFareStrategy(FareStrategy fareStrategy) {

        this.fareStrategy =
                Objects.requireNonNull(fareStrategy);
    }

    /**
     * Creates a ride request.
     */
    public Ride requestRide(Rider rider,
                            String destination,
                            double distance) {

        Ride ride = new Ride(
                IdGenerator.generateRideId(),
                rider,
                rider.getPickupLocation(),
                destination,
                distance
        );

        rides.put(ride.getRideId(), ride);

        return ride;
    }

    /**
     * Assigns the best driver using the configured strategy.
     */
    public void assignDriver(Ride ride) {

        Driver driver = rideMatchingStrategy
                .findDriver(ride, driverService.listDrivers())
                .orElseThrow(() ->
                        new NoDriverAvailableException(
                                "No driver available for ride "
                                        + ride.getRideId()));

        ride.assignDriver(driver);

        driver.updateAvailability(false);
    }

    /**
     * Starts the ride.
     */
    public void startRide(Ride ride) {

        ride.startRide();
    }

    /**
     * Completes the ride.
     */
    public void completeRide(Ride ride) {

        FareReceipt receipt =
                fareStrategy.calculateFare(ride);

        ride.completeRide(receipt);

        Driver driver = ride.getDriver();

        driver.incrementCompletedRideCount();
        driver.updateAvailability(true);
        driver.updateLocation(ride.getDestination());
    }

    /**
     * Cancels the ride.
     */
    public void cancelRide(Ride ride) {

        Driver driver = ride.getDriver();

        ride.cancelRide();

        if (driver != null) {
            driver.updateAvailability(true);
        }
    }

    /**
     * Prints the fare receipt.
     */
    public void printReceipt(Ride ride) {

        FareReceipt receipt = ride.getFareReceipt();

        if (receipt == null) {
            throw new IllegalStateException(
                    "Ride has not been completed.");
        }

        receipt.printReceipt();
    }

    public Ride getRide(String rideId) {

        return rides.get(rideId);
    }
}