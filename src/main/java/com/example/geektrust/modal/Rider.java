package com.example.geektrust.modal;

public class Rider extends CoordinateHolder {
    private final String riderId;

    public Rider(String riderId, int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        this.riderId = riderId;
    }

    public String getId() {
        return riderId;
    }
}