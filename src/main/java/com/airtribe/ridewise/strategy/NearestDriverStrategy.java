package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Matches the first available driver whose location
 * is closest to the rider's pickup location.
 *
 * Since this assignment does not use GPS coordinates,
 * "nearest" is simulated by matching location names.
 */
public class NearestDriverStrategy implements RideMatchingStrategy {

    @Override
    public Optional<Driver> findDriver(
            Ride ride,
            List<Driver> availableDrivers) {

        String pickup = ride.getPickupLocation();

        Optional<Driver> exactMatch = availableDrivers.stream()
                .filter(Driver::isAvailable)
                .filter(driver ->
                        driver.getCurrentLocation()
                                .equalsIgnoreCase(pickup))
                .findFirst();

        if (exactMatch.isPresent()) {
            return exactMatch;
        }

        return availableDrivers.stream()
                .filter(Driver::isAvailable)
                .min(Comparator.comparing(Driver::getDriverId));
    }
}