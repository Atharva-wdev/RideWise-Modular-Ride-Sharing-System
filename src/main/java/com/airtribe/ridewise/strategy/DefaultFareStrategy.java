package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.FareReceipt;
import com.airtribe.ridewise.model.Ride;

/**
 * Default fare calculation strategy.
 */
public class DefaultFareStrategy implements FareStrategy {

    private static final double BASE_FARE = 50.0;
    private static final double PER_KM_RATE = 15.0;
    private static final double GST_PERCENTAGE = 0.05;

    @Override
    public FareReceipt calculateFare(Ride ride) {

        double fareBeforeTax =
                BASE_FARE +
                        (ride.getDistance() * PER_KM_RATE);

        double tax = fareBeforeTax * GST_PERCENTAGE;

        double totalFare = fareBeforeTax + tax;

        return new FareReceipt(
                BASE_FARE,
                1.0,
                tax,
                totalFare
        );
    }
}