package com.example.geektrust.interfaces;

import com.example.geektrust.constants.CommandType;

public interface Command {

    CommandType getType();

    String getCoordinateHolderId();

    String getRideId();

    int getNthDriver();

    int getxCoordinate();

    int getyCoordinate();

    int getTime();
}
