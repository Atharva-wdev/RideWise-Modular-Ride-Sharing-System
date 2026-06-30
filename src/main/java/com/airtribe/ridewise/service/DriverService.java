package com.airtribe.ridewise.service;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.util.IdGenerator;

import java.util.*;

/**
 * Service responsible for driver management.
 */
public class DriverService {

    private final Map<String, Driver> drivers = new LinkedHashMap<>();

    public Driver registerDriver(
            String name,
            String location) {

        Driver driver = new Driver(
                IdGenerator.generateDriverId(),
                name,
                location
        );

        addDriver(driver);

        return driver;
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getDriverId(), driver);
    }

    public Optional<Driver> getDriver(String driverId) {
        return Optional.ofNullable(drivers.get(driverId));
    }

    public void updateAvailability(String driverId, boolean available) {

        Driver driver = drivers.get(driverId);

        if (driver != null) {
            driver.updateAvailability(available);
        }
    }

    public void updateLocation(String driverId, String location) {

        Driver driver = drivers.get(driverId);

        if (driver != null) {
            driver.updateLocation(location);
        }
    }

    public List<Driver> listDrivers() {
        return new ArrayList<>(drivers.values());
    }
}