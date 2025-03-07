package com.megacitycabs.bookingsystem.repository;

import com.megacitycabs.bookingsystem.model.Booking;
import com.megacitycabs.bookingsystem.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerId(Long customerId);
    List<Booking> findByDriverId(Long driverId);
    List<Booking> findByStatus(BookingStatus status);
}