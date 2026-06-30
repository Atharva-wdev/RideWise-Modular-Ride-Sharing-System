package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Matches the available driver having
 * the least completed rides.
 */
public class LeastActiveDriverStrategy
        implements RideMatchingStrategy {

    @Override
    public Optional<Driver> findDriver(
            Ride ride,
            List<Driver> availableDrivers) {

        return availableDrivers.stream()
                .filter(Driver::isAvailable)
                .min(
                        Comparator.comparingInt(
                                Driver::getCompletedRideCount
                        )
                );
    }
}