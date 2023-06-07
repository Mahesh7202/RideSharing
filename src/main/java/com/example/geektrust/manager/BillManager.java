package com.example.geektrust.manager;

import com.example.geektrust.interfaces.*;
import com.example.geektrust.modal.Driver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public class BillManager implements Billing {
    private static final int DECIMAL_SCALE = 2;
    private static final double FARE_RATE = 6.5;
    private static final double BASE_FARE = 50;
    private static final double ADDITIONAL_CHARGE = 2;
    private static final double SERVICE_TAX_PERCENTAGE = 0.2;

    private static final String FORMAT_SIZE = "%.2f";

    private final RideCoordinatorHandler rideManager;
    private final DriverCoordinateHolderManager driverCoordinateHolderManager;
    private final RiderCoordinateHolderManager riderCoordinateHolderManager;
    private ResultPrinter printer;

    public BillManager(RideCoordinatorHandler rideManager, DriverCoordinateHolderManager driverCoordinateHolderManager, RiderCoordinateHolderManager riderCoordinateHolderManager, ResultPrinter printer) {
        this.printer = printer;
        this.rideManager = rideManager;
        this.driverCoordinateHolderManager = driverCoordinateHolderManager;
        this.riderCoordinateHolderManager = riderCoordinateHolderManager;
    }

    @Override
    public void calculateBill(String rideId) {
        Rideable rideEvent = rideManager.getRideById(rideId);
        if (rideEvent == null || !isValidRider(rideEvent.getRiderId())) {
            printer.printInvalidRide();
            return;
        }

        Optional<Holder> rider = riderCoordinateHolderManager.getRiderById(rideEvent.getRiderId());
        if (!rider.isPresent()) {
            printer.printInvalidRide();
            return;
        }

        double distance = calculateDistance(rideEvent, rider.get());
        double totalAmount = calculateTotalAmount(distance, rideEvent.getTime());

        String formattedAmount = formatAmount(totalAmount);
        printer.printBill(rideId, rideEvent.getDriverId(), formattedAmount);
    }

    private boolean isValidRider(String riderId) {
        return riderCoordinateHolderManager.getRiderById(riderId).isPresent();
    }

    private double calculateDistance(Rideable rideEvent, Holder rider) {
        Driver driver = new Driver(rideEvent.getDriverId(), rideEvent.getXCoordinate(), rideEvent.getYCoordinate());
        return roundToDecimalPrecision(rider.calculateDistance(driver));
    }

    private double calculateTotalAmount(double distance, int time) {
        double fare = calculateFare(distance);
        double additionalAmount = calculateAdditionalAmount(time);
        double serviceTax = calculateServiceTax(fare + BASE_FARE + additionalAmount);
        return fare + BASE_FARE + additionalAmount + serviceTax;
    }

    private double calculateFare(double distance) {
        return roundToDecimalPrecision(distance * FARE_RATE);
    }

    private double calculateAdditionalAmount(int time) {
        return time * ADDITIONAL_CHARGE;
    }

    private double calculateServiceTax(double amount) {
        return roundToDecimalPrecision(amount * SERVICE_TAX_PERCENTAGE);
    }

    private String formatAmount(double amount) {
        return String.format(FORMAT_SIZE, amount);
    }

    private double roundToDecimalPrecision(double value) {
        BigDecimal decimal = new BigDecimal(value);
        decimal = decimal.setScale(DECIMAL_SCALE, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }
}
