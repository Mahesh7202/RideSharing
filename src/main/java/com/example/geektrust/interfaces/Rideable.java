package com.example.geektrust.interfaces;

public interface Rideable {
        String getRideId();
        String getStatus();
        void setStatus(String status);
        String getDriverId();
        String getRiderId();
        int getXCoordinate();
        int getYCoordinate();
        int getTime();
        void setXCoordinate(int XCoordinate);
        void setYCoordinate(int YCoordinate);
        void setTime(int time);
}
