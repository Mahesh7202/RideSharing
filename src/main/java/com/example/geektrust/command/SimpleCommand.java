package com.example.geektrust.command;

import com.example.geektrust.constants.CommandType;
import com.example.geektrust.interfaces.Command;

public class SimpleCommand implements Command {

    private final CommandType type;
    private final String coordinateHolderId;

    private final String rideId;

    private final int nthDriver;


    private final int xCoordinate;

    private final int yCoordinate;

    private final int time;


    private static final int DEFAULT_VALUE = 0;



    public SimpleCommand(CommandType type, String coordinateHolderId, int xCoordinate, int yCoordinate) {
        this(type, coordinateHolderId, null, DEFAULT_VALUE, xCoordinate, yCoordinate, DEFAULT_VALUE);
    }

    public SimpleCommand(CommandType type, String rideId){
        this(type, null, rideId, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE,DEFAULT_VALUE);
    }

    public SimpleCommand(CommandType type, String rideId, int nthDriver, String coordinateHolderId) {
        this(type, coordinateHolderId, rideId, nthDriver, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    public SimpleCommand(CommandType type, String rideId, int xCoordinate, int yCoordinate, int time) {
        this(type, null, rideId, DEFAULT_VALUE, xCoordinate, yCoordinate, time);
    }


    public SimpleCommand(CommandType type, String coordinateHolderId, String rideId, int nthDriver, int xCoordinate, int yCoordinate, int time) {
        this.type = type;
        this.coordinateHolderId = coordinateHolderId;
        this.rideId = rideId;
        this.nthDriver = nthDriver;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.time = time;
    }

    @Override
    public CommandType getType(){
        return type;
    }
    @Override
    public String getCoordinateHolderId() {
        return coordinateHolderId;
    }

    @Override
    public String getRideId() {
        return rideId;
    }

    @Override
    public int getNthDriver() {
        return nthDriver;
    }

    @Override
    public int getxCoordinate() {
        return xCoordinate;
    }

    @Override
    public int getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public int getTime() {
        return time;
    }
}

