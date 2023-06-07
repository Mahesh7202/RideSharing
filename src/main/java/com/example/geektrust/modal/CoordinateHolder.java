package com.example.geektrust.modal;

import com.example.geektrust.interfaces.Holder;

public abstract class CoordinateHolder implements Holder {

    private static final double MAX_DISTANCE = 5.0;

    private int xCoordinate;
    private int yCoordinate;

    public CoordinateHolder(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public abstract String getId();

    public boolean isWithinRange(Holder other) {
        double distance = calculateDistance(other);
        return distance <= MAX_DISTANCE;
    }

    public double calculateDistance(Holder other) {
        int x1 = this.getXCoordinate();
        int y1 = this.getYCoordinate();
        int x2 = other.getXCoordinate();
        int y2 = other.getYCoordinate();
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
