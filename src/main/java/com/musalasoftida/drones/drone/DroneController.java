package com.musalasoftida.drones.drone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drones")
public class DroneController {
    @Autowired
    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping
    public List<Drone> getDrones() {
        return droneService.getDrones();

    }

    @PostMapping()
    public Drone createDrone(@RequestBody Drone createDroneRequest) {
        return droneService.createDrone(createDroneRequest);
    }
}
