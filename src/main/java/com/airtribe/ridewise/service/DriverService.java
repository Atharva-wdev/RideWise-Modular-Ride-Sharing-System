package com.airtribe.ridewise.service;

import com.airtribe.ridewise.model.Driver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Service responsible for driver management.
 */
public class DriverService {

    private final Map<String, Driver> drivers = new LinkedHashMap<>();

    public void addDriver(Driver driver) {
        drivers.put(driver.getDriverId(), driver);
    }

    public Driver getDriver(String driverId) {
        return drivers.get(driverId);
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