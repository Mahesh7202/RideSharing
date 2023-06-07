package com.example.geektrust.interfaces;

import com.example.geektrust.modal.Driver;

public interface Holder {
        int getXCoordinate();
        int getYCoordinate();
        String getId();

        double calculateDistance(Holder driver);

        boolean isWithinRange(Holder rider);
}
