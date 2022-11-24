package com.musalasoftida.drones.drone;

import com.musalasoftida.drones.medication.Medication;
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

    //View all drones
    @GetMapping
    public List<Drone> getDrones() {
        return droneService.getDrones();
    }

    //registering a drone
    @PostMapping()
    public Drone createDrone(@RequestBody Drone createDroneRequest) {
        //todo add validation @Valid
        return droneService.createDrone(createDroneRequest);
    }

    //loading a drone with medication items;
    @PutMapping(path = "{droneId}")
    public void load(
            @PathVariable("droneId") Long droneId,
            @RequestParam(required = false) List<Medication> medications) {
        droneService.loadDrone(droneId, medications);
    }

    //get medication items from a drone
    @GetMapping(path = "{droneId}")
    public List<Medication> getMedicationItems(@PathVariable("droneId") Long droneId) {
        return droneService.getMedicationsByDroneId(droneId);
    }

    //check drone battery level for a given drone
    @GetMapping(path = "/battery/{droneId}")
    public Double getBatteryLevel(@PathVariable("droneId") Long droneId) {
        return droneService.getBatteryLevel(droneId);
    }

    //checking available drones for loading
    @GetMapping(path = "/available")
    public List<Drone> getAvailableDrones() {
        return droneService.getAvailableDrones();
    }

}

