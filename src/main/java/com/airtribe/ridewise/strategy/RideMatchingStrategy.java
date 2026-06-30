package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;

import java.util.List;
import java.util.Optional;

/**
 * Strategy interface for selecting a driver for a ride.
 */
public interface RideMatchingStrategy {

    /**
     * Finds the most suitable driver for the given ride.
     *
     * @param ride the requested ride
     * @param availableDrivers list of registered drivers
     * @return selected driver wrapped in Optional
     */
    Optional<Driver> findDriver(
            Ride ride,
            List<Driver> availableDrivers);
}