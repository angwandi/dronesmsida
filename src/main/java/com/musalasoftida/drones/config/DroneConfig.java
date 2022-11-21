package com.musalasoftida.drones.config;

import com.musalasoftida.drones.drone.Drone;
import com.musalasoftida.drones.drone.DroneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DroneConfig {
    @Bean
    CommandLineRunner commandLineRunner(DroneRepository droneRepository) {
        return args -> {

            Drone drone1 = new Drone(
                    "ljdglf",
                    90,
                    "Heavy",
                    "Idle",
                    "Paracetamol"

            );
            Drone drone2 = new Drone(
                    "LKHKJ",
                    57,
                    "Light",
                    "Idle",
                    "Paracetamol 2"

            );
            droneRepository.saveAll(
                    List.of(drone1, drone2)
            );
        }
                ;
    }
}
