package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.model.Booking;
import com.megacitycabs.bookingsystem.model.BookingStatus;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long id);
    List<Booking> getAllBookings();
    List<Booking> getBookingsByCustomer(Long customerId);
    List<Booking> getBookingsByDriver(Long driverId);
    Booking updateBookingStatus(Long id, BookingStatus status);
    void deleteBooking(Long id);
}