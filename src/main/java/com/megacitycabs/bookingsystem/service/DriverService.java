package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.model.Costomers;
import com.megacitycabs.bookingsystem.model.Drivers;
import java.util.List;
import java.util.Optional;

public interface DriverService {
    Drivers registerDriver(Drivers driver);
    Optional<Drivers> getDriverById(Long id);
    List<Drivers> getAllDrivers();
    Drivers updateDriver(Long id, Drivers driverDetails);
    void deleteDriver(Long id);
    Drivers getDriverByUserId(Long userId);
}
