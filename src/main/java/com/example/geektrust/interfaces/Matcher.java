package com.example.geektrust.interfaces;

import java.util.List;
import java.util.Optional;

public interface Matcher {
    void matchRider(String riderId);


    List<String> getMatchedDriverIds(String riderId);

    String getDriverIdMatched(String riderId, int driverIndex);
}
