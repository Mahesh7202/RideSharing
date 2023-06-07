package com.example.geektrust.modal;

import com.example.geektrust.interfaces.Rideable;

public abstract class RideEvent implements Rideable {
    private final String rideId;
    private String status;


    public RideEvent(String rideId, String status) {
        this.rideId = rideId;
        this.status = status;
    }

    public String getRideId() {
        return rideId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
