package com.example.geektrust.command;

import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.CommandHandler;
import com.example.geektrust.interfaces.RideEventManager;

public class StartRideCommandHandler implements CommandHandler {

    private final RideEventManager rideManager;

    public StartRideCommandHandler(RideEventManager rideManager) {
        this.rideManager = rideManager;
    }

    @Override
    public void handleCommand(Command command) {
        String rideId = command.getRideId();
        int nthDriver = command.getNthDriver();
        String coordinateHolderId = command.getCoordinateHolderId();

        rideManager.startRide(rideId, nthDriver, coordinateHolderId);
    }
}
