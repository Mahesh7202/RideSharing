package com.example.geektrust.command;

import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.CommandHandler;
import com.example.geektrust.interfaces.RideEventManager;

public class StopRideCommandHandler implements CommandHandler {

    private final RideEventManager rideManager;

    public StopRideCommandHandler(RideEventManager rideManager) {
        this.rideManager = rideManager;
    }

    @Override
    public void handleCommand(Command command) {
        String rideId = command.getRideId();
        int xCoordinate = command.getxCoordinate();
        int yCoordinate = command.getyCoordinate();
        int time = command.getTime();

        rideManager.stopRide(rideId, xCoordinate, yCoordinate, time);
    }
}
