package com.example.geektrust.modal;

public class Driver extends CoordinateHolder{
    private final String driverId;

    public Driver(String driverId, int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        this.driverId = driverId;
    }

    public String getId() {
        return driverId;
    }


}