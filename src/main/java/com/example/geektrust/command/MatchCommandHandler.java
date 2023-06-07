package com.example.geektrust.command;

import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.CommandHandler;
import com.example.geektrust.interfaces.Matcher;

public class MatchCommandHandler implements CommandHandler {

    private final Matcher matchManager;

    public MatchCommandHandler(Matcher matchManager) {
        this.matchManager = matchManager;
    }

    @Override
    public void handleCommand(Command command) {
        String rideId = command.getRideId();
        matchManager.matchRider(rideId);
    }
}
