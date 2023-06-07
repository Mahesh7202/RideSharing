package com.example.geektrust.manager;

import com.example.geektrust.interfaces.*;

import java.util.*;
import java.util.stream.Collectors;

public class MatchManager implements Matcher {
    private static final int MAX_MATCHED_DRIVERS = 5;

    private final DriverCoordinateHolderManager driverCoordinateHolderManager;
    private final RiderCoordinateHolderManager riderCoordinateHolderManager;
    private final Map<String, List<String>> matchedDriverIds;

    private ResultPrinter printer;

    public MatchManager(DriverCoordinateHolderManager driverCoordinateHolderManager, RiderCoordinateHolderManager riderCoordinateHolderManager, ResultPrinter printer) {
        this.printer = printer;
        this.driverCoordinateHolderManager = driverCoordinateHolderManager;
        this.riderCoordinateHolderManager = riderCoordinateHolderManager;
        this.matchedDriverIds = new HashMap<>();
    }

    @Override
    public void matchRider(String riderId) {
        Optional<Holder> rider = riderCoordinateHolderManager.getRiderById(riderId);
        if (!rider.isPresent()) {
            printer.printInvalidRide();
            return;
        }

        List<Holder> matchedDrivers = findMatchedDrivers(rider.get());
        if (matchedDrivers.isEmpty()) {
            printer.printNoDriversAvailable();
            return;
        }

        List<String> matchedDriverIds = sortDriverIdsByDistance(matchedDrivers, rider.get());
        matchedDriverIds = limitMatchedDriverIds(matchedDriverIds);
        this.matchedDriverIds.put(rider.get().getId(), matchedDriverIds);

        printer.printMatchedDrivers(matchedDriverIds);
    }

    private List<Holder> findMatchedDrivers(Holder rider) {
        return driverCoordinateHolderManager.getDrivers().stream()
                .filter(driver -> driver.isWithinRange(rider))
                .collect(Collectors.toList());
    }

    private List<String> sortDriverIdsByDistance(List<Holder> drivers, Holder rider) {
        return drivers.stream()
                .sorted(Comparator.comparingDouble(driver -> driver.calculateDistance(rider)))
                .map(Holder::getId)
                .collect(Collectors.toList());
    }

    private List<String> limitMatchedDriverIds(List<String> driverIds) {
        return driverIds.stream()
                .limit(MAX_MATCHED_DRIVERS)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getMatchedDriverIds(String riderId) {
        return matchedDriverIds.get(riderId);
    }

    @Override
    public String getDriverIdMatched(String riderId, int driverIndex) {
        List<String> drivers = getMatchedDriverIds(riderId);

        if (drivers == null || driverIndex > drivers.size()) {
            return null;
        }

        String driverId = drivers.get(--driverIndex);
        driverCoordinateHolderManager.removeDriver(driverId);
        return driverId;
    }
}
