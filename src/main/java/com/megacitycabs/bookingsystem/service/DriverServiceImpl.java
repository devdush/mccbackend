package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.model.Costomers;
import com.megacitycabs.bookingsystem.model.Drivers;
import com.megacitycabs.bookingsystem.repository.DriverRepository;
import com.megacitycabs.bookingsystem.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Drivers registerDriver(Drivers driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Optional<Drivers> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    @Override
    public List<Drivers> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Drivers updateDriver(Long id, Drivers driverDetails) {
        return driverRepository.findById(id)
                .map(existingDriver -> {
                    existingDriver.setLicenseNumber(driverDetails.getLicenseNumber());
                    existingDriver.setVehicle(driverDetails.getVehicle());
                    existingDriver.setAvailable(driverDetails.isAvailable());
                    existingDriver.setRating(driverDetails.getRating());
                    return driverRepository.save(existingDriver);
                }).orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
    }

    @Override
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
    @Override
    public Drivers getDriverByUserId(Long userId) {
        Optional<Drivers> driver = driverRepository.findByUserId(userId);
        return driver.orElse(null);
    }
}
