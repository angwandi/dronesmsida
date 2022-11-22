package com.musalasoftida.drones.config;

import com.musalasoftida.drones.drone.Drone;
import com.musalasoftida.drones.drone.DroneRepository;
import com.musalasoftida.drones.utilities.Model;
import com.musalasoftida.drones.utilities.State;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class DroneConfig {

    @Bean
    CommandLineRunner commandLineRunner(DroneRepository bookRepository) {
        return args -> {
            bookRepository.saveAll(
                    List.of(
                            new Drone(
                                    "-~J-G25LZX/-CK#ZV$_V",
                                    45.0,
                                    Model.Heavyweight,
                                    State.IDLE),
                            new Drone(
                                    "+78_C9$YR'&D-~J-G25LZX/",
                                    90.99,
                                    Model.Lightweight,
                                    State.DELIVERED),

                            new Drone(
                                    "QM2AE2GEQTNYG_`^5'@RG^=+M8Z6R+G#H6#",
                                    45.0,
                                    Model.Cruiserweight,
                                    State.RETURNING),
                            new Drone(
                                    "`^5'@RG^=+M8Z6R+G#H6#XM2'TWDMW/",
                                    100.0,
                                    Model.Heavyweight,
                                    State.DELIVERING)
                    )
            );


        };
    }
}
