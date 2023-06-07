package com.example.geektrust.command;

import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.CommandHandler;
import com.example.geektrust.interfaces.DriverCoordinateHolderManager;

public class AddDriverCommandHandler implements CommandHandler {

    private final DriverCoordinateHolderManager driverCoordinateHolderManager;

    public AddDriverCommandHandler(DriverCoordinateHolderManager driverCoordinateHolderManager) {
        this.driverCoordinateHolderManager = driverCoordinateHolderManager;
    }

    @Override
    public void handleCommand(Command command) {
        String driverId = command.getCoordinateHolderId();
        int xCoordinate = command.getxCoordinate();
        int yCoordinate = command.getyCoordinate();

        driverCoordinateHolderManager.addDriver(driverId, xCoordinate, yCoordinate);
    }
}
