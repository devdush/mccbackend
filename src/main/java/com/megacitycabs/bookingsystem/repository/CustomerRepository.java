package com.megacitycabs.bookingsystem.repository;

import com.megacitycabs.bookingsystem.model.Costomers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Costomers,Long> {

}
