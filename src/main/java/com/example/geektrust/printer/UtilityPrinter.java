package com.example.geektrust.printer;

import com.example.geektrust.interfaces.ResultPrinter;

import java.util.List;

public class UtilityPrinter implements ResultPrinter {

    private static final String MESSAGE_DRIVERS_MATCHED = "DRIVERS_MATCHED";
    private static final String MESSAGE_NO_DRIVERS_AVAILABLE = "NO_DRIVERS_AVAILABLE";
    private static final String MESSAGE_INVALID_RIDE = "INVALID_RIDE";
    private static final String MESSAGE_RIDE_STARTED = "RIDE_STARTED";
    private static final String MESSAGE_RIDE_STOPPED = "RIDE_STOPPED";
    private static final String MESSAGE_BILL = "BILL";

    public void printMatchedDrivers(List<String> driverIds) {
        printMessage(MESSAGE_DRIVERS_MATCHED + " " + String.join(" ", driverIds));
    }

    public void printNoDriversAvailable() {
        printMessage(MESSAGE_NO_DRIVERS_AVAILABLE);
    }

    public void printInvalidRide() {
        printMessage(MESSAGE_INVALID_RIDE);
    }

    public void printRideStarted(String rideId) {
        printMessage(MESSAGE_RIDE_STARTED + " " + rideId);
    }

    public void printRideStopped(String rideId) {
        printMessage(MESSAGE_RIDE_STOPPED + " " + rideId);
    }

    public void printBill(String rideId, String driverId, String totalAmount) {
        printMessage(MESSAGE_BILL + " " + rideId + " " + driverId + " " + totalAmount);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
