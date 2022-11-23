package com.musalasoftida.drones.config;

import com.musalasoftida.drones.drone.Drone;
import com.musalasoftida.drones.drone.DroneRepository;
import com.musalasoftida.drones.medication.Medication;
import com.musalasoftida.drones.medication.MedicationRepository;
import com.musalasoftida.drones.utilities.Model;
import com.musalasoftida.drones.utilities.State;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class DroneConfig {

    @Bean
    CommandLineRunner commandLineRunner(DroneRepository droneRepository, MedicationRepository medicationRepository) {
        return args -> {

            Medication medication1 = new Medication("para", 200, "4K49RLHW4V4J_YU", "4K49HxbdvfbdfbW4V4J");
            Medication medication2 = new Medication("paraceta", 350, "4K49RW4V4J", "4K49RLHW4V4eyergegrgJ");
            Medication medication3 = new Medication("paracetamol", 450, "4K49RLHW4J", "4K49RLHfgdfgdfgW4V4J");


            Drone drone = new Drone(
                    "LO03X-KYWQG-VIOXE-QWTNL-AOKPF-MMAEC",
                    45.0,
                    Model.Heavyweight,
                    State.IDLE,
                    List.of(medication1, medication3)
            );
            drone = droneRepository.save(drone);
            List<Medication> medicationList = new ArrayList<>(List.of(medication1, medication2, medication3));
           /* Drone drone1 = new Drone(
                    "LO03X-KYWQG-VIOXE-QWTNL-AOKPF-MMAEC",
                    45.0,
                    Model.Heavyweight,
                    State.IDLE,
                    List.of(medication1, medication1)
            );
            Drone drone2 = new Drone(
                    "+78_C9$YR'&D-~J-G25LZX/",
                    90.99,
                    Model.Lightweight,
                    State.DELIVERED,
                    List.of(medication1, medication3, medication1)
            );
            Drone drone3 = new Drone(
                    "QM2AE2GEQTNYG_`^5'@RG^=+M8Z6R+G#H6#",
                    45.0,
                    Model.Cruiserweight,
                    State.RETURNING,
                    List.of(medication1, medication2)
            );
            Drone drone4 = new Drone(
                    "`^5'@RG^=+M8Z6R+G#H6#XM2'TWDMW/",
                    100.0,
                    Model.Heavyweight,
                    State.DELIVERING,
                    List.of(medication1, medication2)
            );*/
            medicationRepository.saveAll(medicationList);
            drone.setMedications(medicationList);
            droneRepository.save(drone);

        };
    }
}
