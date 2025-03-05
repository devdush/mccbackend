package com.megacitycabs.bookingsystem.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String plateNumber;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int capacity;

}