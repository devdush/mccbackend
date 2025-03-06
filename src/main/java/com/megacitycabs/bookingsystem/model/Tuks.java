package com.megacitycabs.bookingsystem.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Tuks") // This value will be stored in the `vehicle_type` column
@Getter
@Setter
public class Tuks extends Vehicle {

}
