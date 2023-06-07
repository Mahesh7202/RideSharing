package com.example.geektrust.modal;

import com.example.geektrust.interfaces.Rideable;

public class Ride extends RideEvent implements Rideable {

    private String driverId;
    private String riderId;

    private int XCoordinate;
    private int YCoordinate;

    private int time;

    public Ride(String rideId, String status,String riderId, String driverId) {
        super(rideId, status);
        this.riderId = riderId;
        this.driverId = driverId;
    }

    public Ride(String rideId, String status, int XCoordinate, int YCoordinate, int time) {
        super(rideId, status);
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
        this.time = time;
    }

    public String getDriverId() {
        return driverId;
    }


    public int getXCoordinate() {
        return XCoordinate;
    }

    public int getYCoordinate() {
        return YCoordinate;
    }

    public int getTime() {
        return time;
    }

    public void setXCoordinate(int XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public void setYCoordinate(int YCoordinate) {
        this.YCoordinate = YCoordinate;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String getRiderId() {
        return riderId;
    }
}
