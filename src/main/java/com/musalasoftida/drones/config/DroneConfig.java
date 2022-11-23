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
            Medication medication1 = new Medication("para", 200, "4K49RLHW4V4J_YU", "https://www.drugs.com/images/pills/paracetamol.jpg");
            Medication medication2 = new Medication("paracetamol", 350, "4K494K49RLHW4V4J_YURW4V4J", "https://www.drugs.com/images/pills/paracetamol.jpg");
            Medication medication3 = new Medication("paraceta", 100, "4K494K49RLHW4V4J_YU4K49RLHW4V4J_YURW4V4J", "https://www.drugs.com/images/pills/paracetamol.jpg");
            Drone drone = new Drone(
                    "LO03X-KYWQG-VIOXE-QWTNL-AOKPF-MMAEC",
                    45.0,
                    Model.Heavyweight,
                    State.IDLE,
                    List.of(medication1, medication2,medication3)
            );

            List<Medication> medicationList = new ArrayList<>(List.of(medication1, medication2,medication3));


            if (drone.getMedications() != null) {
                for (Medication medication : drone.getMedications()) {
                    medication.setDrone(drone);
                    medicationRepository.saveAll(medicationList);
                }
            }

            drone.setMedications(medicationList);
            droneRepository.save(drone);
        };
    }
}
