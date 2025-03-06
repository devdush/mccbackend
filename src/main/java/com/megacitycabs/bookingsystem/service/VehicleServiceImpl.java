package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.factory.VehicleFactory;
import com.megacitycabs.bookingsystem.model.Vehicle;
import com.megacitycabs.bookingsystem.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(String type, Vehicle vehicleDetails) {
        Vehicle vehicle = VehicleFactory.createVehicle(type);
        vehicle.setPlateNumber(vehicleDetails.getPlateNumber());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setCapacity(vehicleDetails.getCapacity());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    @Transactional
    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle vehicle = getVehicleById(id);
        vehicle.setPlateNumber(vehicleDetails.getPlateNumber());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setCapacity(vehicleDetails.getCapacity());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
