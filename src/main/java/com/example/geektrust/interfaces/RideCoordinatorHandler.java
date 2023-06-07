package com.example.geektrust.interfaces;

import com.example.geektrust.modal.Ride;

public interface RideCoordinatorHandler {
    Ride startRide(String rideId, int driverIndex, String riderId);

    void stopRide(Ride ride, int xCoordinate, int yCoordinate, int time);

    Ride getRideById(String rideId);
}
