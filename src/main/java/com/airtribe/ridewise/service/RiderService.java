package com.airtribe.ridewise.service;

import com.airtribe.ridewise.model.Rider;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Service responsible for rider management.
 */
public class RiderService {

    private final Map<String, Rider> riders = new LinkedHashMap<>();

    public void addRider(Rider rider) {
        riders.put(rider.getRiderId(), rider);
    }

    public Rider getRider(String riderId) {
        return riders.get(riderId);
    }

    public Collection<Rider> listRiders() {
        return riders.values();
    }
}