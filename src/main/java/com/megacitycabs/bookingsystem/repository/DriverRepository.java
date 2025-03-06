package com.megacitycabs.bookingsystem.repository;


import com.megacitycabs.bookingsystem.model.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Drivers, Long> {
    Optional<Drivers> findByUserId(Long userId);
}
