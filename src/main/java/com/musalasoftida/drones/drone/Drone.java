package com.musalasoftida.drones.drone;


import com.musalasoftida.drones.utilities.Model;
import com.musalasoftida.drones.utilities.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Setter
@Getter
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 100, message = "Serial number is too long")
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @Transient
    private Integer weightLimit;
    @Min(value = 0, message = "Battery capacity must be greater than or equal to 0")
    @Max(value = 100, message = "Battery capacity must be less than or equal to 100")
    private Double batteryCapacity;
    @NotNull(message = "Valid model type is required")
    private Model model;
    @Enumerated(EnumType.STRING)
    private State state;

    public Drone(String serialNumber, Double batteryCapacity, Model model, State state) {
        this.serialNumber = serialNumber;
        this.batteryCapacity = batteryCapacity;
        this.model = model;
        this.state = state;
    }

    //getting transient field weightLimit from model
    public Integer getWeightLimit() {
        switch (Model.valueOf(model.toString())) {
            case Middleweight -> {
                this.weightLimit = 200;
            }
            case Cruiserweight -> {
                this.weightLimit = 300;
            }
            case Heavyweight -> {
                this.weightLimit = 500;
            }
            default -> {
                this.weightLimit = 100;
            }
        }
        return weightLimit;
    }

}