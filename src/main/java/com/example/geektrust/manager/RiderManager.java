package com.example.geektrust.manager;

import com.example.geektrust.interfaces.Holder;
import com.example.geektrust.interfaces.RiderCoordinateHolderManager;
import com.example.geektrust.modal.Rider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RiderManager implements RiderCoordinateHolderManager {
    private List<Holder> riders;

    public RiderManager() {
        riders = new ArrayList<>();
    }

    public void addRider(String riderId, int xCoordinate, int yCoordinate) {
        Holder rider = createRider(riderId, xCoordinate, yCoordinate);
        riders.add(rider);
    }

    public List<Holder> getRiders() {
        return riders;
    }

    @Override
    public Optional<Holder> getRiderById(String id) {
        return riders.stream()
                .filter(rider -> rider.getId().equals(id))
                .findFirst();
    }

    private Holder createRider(String riderId, int xCoordinate, int yCoordinate) {
        return new Rider(riderId, xCoordinate, yCoordinate);
    }
}
