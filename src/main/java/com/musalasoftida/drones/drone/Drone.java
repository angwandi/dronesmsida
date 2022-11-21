package com.musalasoftida.drones.drone;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drone")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    @NotNull
    private String serialNumber;
    @NotNull
    @Column(name = "battery_capacity")
    @Range(min = 0, max = 100)
    private int batteryCapacity;
    @javax.validation.constraints.NotNull(message = "Valid model type is required")
    private String model;
    @Column(name = "state")
    private String state;
    private String medication;

    public Drone(String serialNumber,
                 int batteryCapacity,
                 String model,
                 String state,
                 String medication) {
        this.serialNumber = serialNumber;
        this.batteryCapacity = batteryCapacity;
        this.model = model;
        this.state = state;
        this.medication = medication;
    }
}
