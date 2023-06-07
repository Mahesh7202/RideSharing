package com.example.geektrust.manager;

import com.example.geektrust.interfaces.DriverCoordinateHolderManager;
import com.example.geektrust.interfaces.Holder;
import com.example.geektrust.modal.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverManager implements DriverCoordinateHolderManager {
    private List<Holder> drivers;

    public DriverManager() {
        drivers = new ArrayList<>();
    }

    public void addDriver(String driverId, int xCoordinate, int yCoordinate) {
        drivers.add(new Driver(driverId, xCoordinate, yCoordinate));
    }

    public List<Holder> getDrivers() {
        return drivers;
    }


    public void removeDriver(String driverId) {
        drivers.removeIf(driver -> driver.getId().equals(driverId));
    }
}
