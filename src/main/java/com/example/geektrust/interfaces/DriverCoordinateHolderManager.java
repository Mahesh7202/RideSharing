package com.example.geektrust.interfaces;

import java.util.List;

public interface DriverCoordinateHolderManager {
    void addDriver(String driverId, int xCoordinate, int yCoordinate);
    List<Holder> getDrivers();
    void removeDriver(String driverId);
}
