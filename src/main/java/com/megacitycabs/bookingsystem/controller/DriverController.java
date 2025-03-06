package com.megacitycabs.bookingsystem.controller;

import com.megacitycabs.bookingsystem.model.Drivers;
import com.megacitycabs.bookingsystem.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/register")
    public ResponseEntity<Drivers> registerDriver(@RequestBody Drivers driver) {
        Drivers savedDriver = driverService.registerDriver(driver);
        return ResponseEntity.ok(savedDriver);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drivers> getDriverById(@PathVariable Long id) {
        Optional<Drivers> driver = driverService.getDriverById(id);
        return driver.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Drivers> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drivers> updateDriver(@PathVariable Long id, @RequestBody Drivers driverDetails) {
        Drivers updatedDriver = driverService.updateDriver(id, driverDetails);
        return ResponseEntity.ok(updatedDriver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}
