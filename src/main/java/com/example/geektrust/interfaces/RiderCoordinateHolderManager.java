package com.example.geektrust.interfaces;

import java.util.List;
import java.util.Optional;

public interface RiderCoordinateHolderManager {
    void addRider(String riderId, int xCoordinate, int yCoordinate);
    List<Holder> getRiders();

    Optional<Holder> getRiderById(String id);
}