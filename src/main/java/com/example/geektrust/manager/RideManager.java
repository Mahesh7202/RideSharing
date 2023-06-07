package com.example.geektrust.manager;
import com.example.geektrust.interfaces.ResultPrinter;
import com.example.geektrust.interfaces.RideCoordinatorHandler;
import com.example.geektrust.interfaces.RideEventManager;
import com.example.geektrust.modal.Ride;

public class RideManager implements RideEventManager {
    private RideCoordinatorHandler rideCoordinator;
    private ResultPrinter printer;

    private static final String RIDE_STOPPED = "RIDE_STOPPED";
    public RideManager(RideCoordinatorHandler rideCoordinator, ResultPrinter printer) {
        this.rideCoordinator = rideCoordinator;
        this.printer = printer;
    }

    public void startRide(String rideId, int driverIndex, String riderId) {
        Ride ride = getStartedRide(rideId, driverIndex, riderId);
        if (ride == null) {
            printer.printInvalidRide();
            return;
        }

        printer.printRideStarted(ride.getRideId());
    }

    public void stopRide(String rideId, int xCoordinate, int yCoordinate, int time) {
        Ride ride = getValidRide(rideId);
        if (ride == null) {
            printer.printInvalidRide();
            return;
        }

        updateRideStopDetails(ride, xCoordinate, yCoordinate, time);
        printer.printRideStopped(ride.getRideId());
    }

    private Ride getStartedRide(String rideId, int driverIndex, String riderId) {
        return rideCoordinator.startRide(rideId, driverIndex, riderId);
    }

    private Ride getValidRide(String rideId) {
        Ride ride = rideCoordinator.getRideById(rideId);
        if (ride == null || ride.getStatus().equals(RIDE_STOPPED)) {
            return null;
        }
        return ride;
    }

    private void updateRideStopDetails(Ride ride, int xCoordinate, int yCoordinate, int time) {
        rideCoordinator.stopRide(ride, xCoordinate, yCoordinate, time);
    }
}
