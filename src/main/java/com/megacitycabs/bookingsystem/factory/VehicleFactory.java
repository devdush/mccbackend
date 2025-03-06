package com.megacitycabs.bookingsystem.factory;

import com.megacitycabs.bookingsystem.model.*;

public class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        return switch (type.toLowerCase()) {
            case "cars" -> new Cars();
            case "vans" -> new Vans();
            case "tuks" -> new Tuks();
            case "mini" -> new Mini();
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        };
    }
}
