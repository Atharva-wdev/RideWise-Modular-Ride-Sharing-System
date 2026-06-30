package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.FareReceipt;
import com.airtribe.ridewise.model.Ride;

/**
 * Strategy interface for fare calculation.
 */
public interface FareStrategy {

    /**
     * Calculates the fare for a ride.
     *
     * @param ride ride to calculate fare for
     * @return generated fare receipt
     */
    FareReceipt calculateFare(Ride ride);
}