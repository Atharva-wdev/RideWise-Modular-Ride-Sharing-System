package com.airtribe.ridewise;

import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideService;
import com.airtribe.ridewise.service.RiderService;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.LeastActiveDriverStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.PeakHourFareStrategy;

/**
 * Entry point of RideWise.
 */
public class Main {

    public static void main(String[] args) {

        RiderService riderService = new RiderService();

        DriverService driverService = new DriverService();

        RideService rideService =
                new RideService(
                        riderService,
                        driverService,
                        new NearestDriverStrategy(),
                        new DefaultFareStrategy());

        Rider rider1 =
                riderService.registerRider(
                        "Atharva",
                        "Pune");

        Rider rider2 =
                riderService.registerRider(
                        "Rahul",
                        "Mumbai");

        Rider rider3 =
                riderService.registerRider(
                        "Priya",
                        "Nagpur");

        driverService.registerDriver("Driver A", "Pune");
        driverService.registerDriver("Driver B", "Mumbai");
        driverService.registerDriver("Driver C", "Nagpur");
        driverService.registerDriver("Driver D", "Pune");
        driverService.registerDriver("Driver E", "Mumbai");

        System.out.println("========== Ride 1 ==========");

        Ride ride1 =
                rideService.requestRide(
                        rider1,
                        "Airport",
                        12);

        rideService.assignDriver(ride1);
        rideService.startRide(ride1);
        rideService.completeRide(ride1);
        rideService.printReceipt(ride1);

        System.out.println();

        System.out.println(
                "Switching Ride Matching Strategy..."
        );

        rideService.setRideMatchingStrategy(
                new LeastActiveDriverStrategy());

        Ride ride2 =
                rideService.requestRide(
                        rider2,
                        "Railway Station",
                        8);

        rideService.assignDriver(ride2);
        rideService.startRide(ride2);
        rideService.completeRide(ride2);
        rideService.printReceipt(ride2);

        System.out.println();

        System.out.println(
                "Switching Fare Strategy..."
        );

        rideService.setFareStrategy(
                new PeakHourFareStrategy());

        Ride ride3 =
                rideService.requestRide(
                        rider3,
                        "IT Park",
                        20);

        rideService.assignDriver(ride3);
        rideService.startRide(ride3);
        rideService.completeRide(ride3);
        rideService.printReceipt(ride3);

        System.out.println();

        System.out.println(
                "RideWise demo completed successfully.");
    }
}