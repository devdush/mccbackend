package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle createVehicle(String type, Vehicle vehicleDetails);
    Vehicle getVehicleById(Long id);
    List<Vehicle> getAllVehicles();
    Vehicle updateVehicle(Long id, Vehicle vehicleDetails);
    void deleteVehicle(Long id);
}
