package com.musalasoftida.drones.medication;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.musalasoftida.drones.drone.Drone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = "^[\\w-]+$")
    @NotNull(message = "Valid name is required")
    private String name;
    private Integer weight;
    //@Pattern(regexp = "^[A-Z0-9_]{11,15}$") todo: add regex for code
    private String code;
    //todo add image module as byte array
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drone_id")
    @JsonBackReference
    public Drone drone;

    public Medication(String name, Integer weight, String code, String image) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
    }

}
