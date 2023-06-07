package com.example.geektrust.interfaces;

import java.util.Map;

public interface RideEventManager {
    void startRide(String rideId, int driverIndex, String riderId);
    void stopRide(String rideId, int xCoordinate, int yCoordinate, int time);

}
