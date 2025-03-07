package com.megacitycabs.bookingsystem.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Costomers customer;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Drivers driver;

    @Column(nullable = false)
    private String pickupLocation;

    @Column(nullable = false)
    private String dropoffLocation;

    private double distance;

    private double fare;

    @Enumerated(EnumType.STRING)
    private BookingStatus status; // PENDING, ACCEPTED, ON_TRIP, COMPLETED, CANCELLED

    private LocalDateTime bookingTime;
}
