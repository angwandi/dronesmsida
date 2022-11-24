package com.musalasoftida.drones.drone;

import com.musalasoftida.drones.utilities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findAllByState(State state);
}


