package com.megacitycabs.bookingsystem.repository;

import com.megacitycabs.bookingsystem.model.Costomers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Costomers,Long> {
    Optional<Costomers> findByUserId(Long userId);
}
