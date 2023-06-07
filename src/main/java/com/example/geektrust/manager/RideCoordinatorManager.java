package com.example.geektrust.manager;

import com.example.geektrust.interfaces.Matcher;
import com.example.geektrust.interfaces.RideCoordinatorHandler;
import com.example.geektrust.modal.Ride;

import java.util.HashMap;
import java.util.Map;

public class RideCoordinatorManager implements RideCoordinatorHandler {
    private Map<String, Ride> rides;
    private Matcher matchManager;

    private static final String RIDE_STARTED = "RIDE_STARTED";
    private static final String RIDE_STOPPED = "RIDE_STOPPED";
    public RideCoordinatorManager(Matcher matchManager) {
        this.matchManager = matchManager;
        this.rides = new HashMap<>();
    }

    public Ride startRide(String rideId, int driverIndex, String riderId) {
        if (hasRide(rideId)) {
            return null;
        }

        String driverId = getMatchedDriverId(driverIndex, riderId);
        if (driverId == null) {
            return null;
        }

        Ride ride = createRide(rideId, riderId, driverId);
        addRide(ride);
        return ride;
    }

    public void stopRide(Ride ride, int xCoordinate, int yCoordinate, int time) {
        setRideStopDetails(ride, xCoordinate, yCoordinate, time);
    }

    public Ride getRideById(String rideId) {
        return rides.get(rideId);
    }

    private boolean hasRide(String rideId) {
        return rides.containsKey(rideId);
    }

    private String getMatchedDriverId(int driverIndex, String riderId) {
        return matchManager.getDriverIdMatched(riderId, driverIndex);
    }

    private Ride createRide(String rideId, String riderId, String driverId) {
        return new Ride(rideId, RIDE_STARTED, riderId, driverId);
    }

    private void addRide(Ride ride) {
        rides.put(ride.getRideId(), ride);
    }

    private void setRideStopDetails(Ride ride, int xCoordinate, int yCoordinate, int time) {
        ride.setStatus(RIDE_STOPPED);
        ride.setXCoordinate(xCoordinate);
        ride.setYCoordinate(yCoordinate);
        ride.setTime(time);
    }
}
