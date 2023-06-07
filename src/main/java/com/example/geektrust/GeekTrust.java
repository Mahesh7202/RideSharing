package com.example.geektrust;

import com.example.geektrust.command.SimpleCommandBuilder;
import com.example.geektrust.command.SimpleCommandExecutor;
import com.example.geektrust.interfaces.*;
import com.example.geektrust.io.FileCommandReader;
import com.example.geektrust.printer.UtilityPrinter;
import com.example.geektrust.manager.*;


import java.io.IOException;

public class GeekTrust {
    private String filepath;

    GeekTrust(String filepath) {
        this.filepath = filepath;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the input file path.");
            return;
        }

        GeekTrust main = new GeekTrust(args[0]);
        main.start();
    }

    public void start() {
        try {
            CommandReader fileCommandReader = new FileCommandReader(filepath);
            CommandParser simpleCommandBuilder = new SimpleCommandBuilder();

            ResultPrinter printer = new UtilityPrinter();

            DriverCoordinateHolderManager driverManager = new DriverManager();
            RiderCoordinateHolderManager riderManager = new RiderManager();

            Matcher matchManager = new MatchManager(driverManager, riderManager, printer);

            RideCoordinatorHandler rideCoordinator = new RideCoordinatorManager(matchManager);
            RideEventManager rideManager = new RideManager(rideCoordinator,printer);

            Billing billManager = new BillManager(rideCoordinator, driverManager, riderManager, printer);

            CommandExecutor simpleCommandExecutor = new SimpleCommandExecutor(driverManager, riderManager, matchManager, rideManager, billManager);

            executeCommands(fileCommandReader, simpleCommandBuilder, simpleCommandExecutor);

            fileCommandReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void executeCommands(CommandReader commandReader, CommandParser commandParser, CommandExecutor commandExecutor) throws IOException {
        String commandString;
        while ((commandString = commandReader.readNextCommand()) != null) {
            Command command = commandParser.parseCommand(commandString);
            if (command != null) {
                commandExecutor.executeCommand(command);
            }
        }
    }
}
