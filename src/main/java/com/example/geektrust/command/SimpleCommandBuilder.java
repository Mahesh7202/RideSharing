package com.example.geektrust.command;

import com.example.geektrust.constants.CommandType;
import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.CommandParser;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SimpleCommandBuilder implements CommandParser {
    private final Map<CommandType, Function<String[], Command>> parserMap;
    private static final String COMMAND_SEPARATOR = " ";


    public SimpleCommandBuilder() {
        parserMap = new HashMap<>();
        parserMap.put(CommandType.ADD_DRIVER, this::parseAddDriverCommand);
        parserMap.put(CommandType.ADD_RIDER, this::parseAddRiderCommand);
        parserMap.put(CommandType.MATCH, this::parseMatchCommand);
        parserMap.put(CommandType.START_RIDE, this::parseStartRideCommand);
        parserMap.put(CommandType.STOP_RIDE, this::parseStopRideCommand);
        parserMap.put(CommandType.BILL, this::parseBillCommand);
    }

    public Command parseCommand(String commandString) {
        String[] tokens = commandString.split(COMMAND_SEPARATOR);
        CommandType type = CommandType.fromString(extractType(tokens));
        if (type == null) {
            return null;
        }

        Function<String[], Command> parserFunction = parserMap.get(type);
        if (parserFunction != null) {
            return parserFunction.apply(tokens);
        }

        return null;
    }


    private SimpleCommand parseAddDriverCommand(String[] tokens) {
        return new SimpleCommand(
                CommandType.ADD_DRIVER,
                extractId(tokens),
                extractXCoordinate(tokens),
                extractYCoordinate(tokens)
        );
    }

    private SimpleCommand parseAddRiderCommand(String[] tokens) {
        return new SimpleCommand(
                CommandType.ADD_RIDER,
                extractId(tokens),
                extractXCoordinate(tokens),
                extractYCoordinate(tokens)
        );
    }

    private SimpleCommand parseMatchCommand(String[] tokens) {
        return new SimpleCommand(
                CommandType.MATCH,
                extractId(tokens)
        );
    }

    private SimpleCommand parseStartRideCommand(String[] tokens) {
        return new SimpleCommand(
                CommandType.START_RIDE,
                extractId(tokens),
                extractNthDriver(tokens),
                extractRiderId(tokens)
        );
    }

    private SimpleCommand parseStopRideCommand(String[] tokens) {
        return new SimpleCommand(
                CommandType.STOP_RIDE,
                extractId(tokens),
                extractXCoordinate(tokens),
                extractYCoordinate(tokens),
                extractTime(tokens)
        );
    }

    private SimpleCommand parseBillCommand(String[] tokens) {
        return new SimpleCommand(
                CommandType.BILL,
                extractId(tokens)
        );
    }

    private String extractType(String[] tokens) {
        return tokens[0];
    }

    private String extractId(String[] tokens) {
        return tokens[1];
    }

    private String extractRiderId(String[] tokens) {
        return tokens[3];
    }

    private int extractNthDriver(String[] tokens) {
        return Integer.parseInt(tokens[2]);
    }

    private int extractTime(String[] tokens) {
        return Integer.parseInt(tokens[4]);
    }

    private int extractXCoordinate(String[] tokens) {
        return Integer.parseInt(tokens[2]);
    }

    private int extractYCoordinate(String[] tokens) {
        return Integer.parseInt(tokens[3]);
    }
}
