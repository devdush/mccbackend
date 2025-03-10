package com.megacitycabs.bookingsystem.controller;

import com.megacitycabs.bookingsystem.model.Booking;
import com.megacitycabs.bookingsystem.model.BookingStatus;
import com.megacitycabs.bookingsystem.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getBookingsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(bookingService.getBookingsByCustomer(customerId));
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<Booking>> getBookingsByDriver(@PathVariable Long driverId) {
        return ResponseEntity.ok(bookingService.getBookingsByDriver(driverId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Booking> updateBookingStatus(@PathVariable Long id, @RequestParam BookingStatus status) {
        return ResponseEntity.ok(bookingService.updateBookingStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}