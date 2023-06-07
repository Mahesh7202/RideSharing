package com.example.geektrust.command;

import com.example.geektrust.constants.CommandType;
import com.example.geektrust.interfaces.*;

import java.util.HashMap;
import java.util.Map;

public class SimpleCommandExecutor implements CommandExecutor {

    private Map<CommandType, CommandHandler> commandHandlers;

    public SimpleCommandExecutor(DriverCoordinateHolderManager driverCoordinateHolderManager, RiderCoordinateHolderManager riderCoordinateHolderManager, Matcher matchManager, RideEventManager rideManager, Billing billManager) {
        commandHandlers = new HashMap<>();
        commandHandlers.put(CommandType.ADD_DRIVER, new AddDriverCommandHandler(driverCoordinateHolderManager));
        commandHandlers.put(CommandType.ADD_RIDER, new AddRiderCommandHandler(riderCoordinateHolderManager));
        commandHandlers.put(CommandType.MATCH, new MatchCommandHandler(matchManager));
        commandHandlers.put(CommandType.START_RIDE, new StartRideCommandHandler(rideManager));
        commandHandlers.put(CommandType.STOP_RIDE, new StopRideCommandHandler(rideManager));
        commandHandlers.put(CommandType.BILL, new CalculateBillCommandHandler(billManager));
    }

    @Override
    public void executeCommand(Command command) {
        CommandType commandType = command.getType();
        CommandHandler handler = commandHandlers.get(commandType);

        if (handler != null) {
            handler.handleCommand(command);
        }
    }
}
