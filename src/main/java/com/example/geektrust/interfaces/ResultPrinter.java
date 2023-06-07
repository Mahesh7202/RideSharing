package com.example.geektrust.interfaces;

import java.util.List;

public interface ResultPrinter {
    void printMatchedDrivers(List<String> driverIds);
    void printNoDriversAvailable();
    void printInvalidRide();
    void printRideStarted(String rideId);
    void printRideStopped(String rideId);
    void printBill(String rideId, String driverId, String totalAmount);
}
