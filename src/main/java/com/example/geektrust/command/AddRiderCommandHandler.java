package com.example.geektrust.command;

import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.CommandHandler;
import com.example.geektrust.interfaces.RiderCoordinateHolderManager;

public class AddRiderCommandHandler implements CommandHandler {

    private final RiderCoordinateHolderManager riderCoordinateHolderManager;

    public AddRiderCommandHandler(RiderCoordinateHolderManager riderCoordinateHolderManager) {
        this.riderCoordinateHolderManager = riderCoordinateHolderManager;
    }

    @Override
    public void handleCommand(Command command) {
        String riderId = command.getCoordinateHolderId();
        int xCoordinate = command.getxCoordinate();
        int yCoordinate = command.getyCoordinate();

        riderCoordinateHolderManager.addRider(riderId, xCoordinate, yCoordinate);
    }
}
