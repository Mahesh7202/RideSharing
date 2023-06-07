package com.example.geektrust.command;

import com.example.geektrust.interfaces.Billing;
import com.example.geektrust.interfaces.Command;
import com.example.geektrust.interfaces.CommandHandler;

public class CalculateBillCommandHandler implements CommandHandler {

    private final Billing billManager;

    public CalculateBillCommandHandler(Billing billManager) {
        this.billManager = billManager;
    }

    @Override
    public void handleCommand(Command command) {
        String rideId = command.getRideId();
        billManager.calculateBill(rideId);
    }
}
