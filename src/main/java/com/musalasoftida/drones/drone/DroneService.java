package com.musalasoftida.drones.drone;

import com.musalasoftida.drones.medication.Medication;
import com.musalasoftida.drones.medication.MedicationRepository;
import com.musalasoftida.drones.utilities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DroneService {
    @Autowired
    private final DroneRepository droneRepository;

    @Autowired
    private final MedicationRepository medicationRepository;

    public DroneService(DroneRepository droneRepository, MedicationRepository medicationRepository) {
        this.droneRepository = droneRepository;
        this.medicationRepository = medicationRepository;
    }

    // Get all drones
    public List<Drone> getDrones(
    ) {
        return droneRepository.findAll();

    }

    //Register a new drone
    //todo check if drone already exists and less than or equal to 10 drones
    public Drone createDrone(Drone drone) {
        List<Medication> medicationsList = new ArrayList<>();
        if (drone.getMedications() != null) {
            for (Medication createMedicationRequest : drone.getMedications()) {
                Medication medicationResult = new Medication();
                medicationResult.setName(createMedicationRequest.getName());
                medicationResult.setCode(createMedicationRequest.getCode());
                medicationResult.setWeight(createMedicationRequest.getWeight());
                medicationResult.setImage(createMedicationRequest.getImage());
                medicationResult.setDrone(drone);
                medicationsList.add(medicationResult);
            }
            medicationRepository.saveAll(medicationsList);

        }
        drone.setMedications(medicationsList);
        drone = droneRepository.save(drone);
        return drone;

    }

    //load a drone with medications
    @Transactional
    public void loadDrone(Long id, List<Medication> medications) {
        Drone drone = droneRepository.findById(id).orElseThrow(() -> new IllegalStateException("Drone not found"));
        //Prevent the drone from being loaded with more weight that it can carry todo;
        //Prevent the drone from being in LOADING state if the battery level is below 25%;

        if (drone.getBatteryCapacity() >= 25) {
            for (Medication medication : medications) {
                Medication medicationResult = new Medication();
                medicationResult.setName(medication.getName());
                medicationResult.setCode(medication.getCode());
                medicationResult.setWeight(medication.getWeight());
                medicationResult.setImage(medication.getImage());
                medicationResult.setDrone(drone);
                medicationRepository.saveAll(medications);
            }
            drone.setMedications(medications);
            droneRepository.save(drone);


        }
    }

    //get medications by drone id
    public List<Medication> getMedicationsByDroneId(Long id) {
        Drone drone = droneRepository.findById(id).orElseThrow(() -> new IllegalStateException("Drone not found"));
        return drone.getMedications();
    }

    //check drone battery level for a given drone id
    public Double getBatteryLevel(Long id) {
        Drone drone = droneRepository.findById(id).orElseThrow(() -> new IllegalStateException("Drone not found"));
        return drone.getBatteryCapacity();
    }

    //checking available drones for loading
    public List<Drone> getAvailableDrones() {
        return droneRepository.findAllByState(State.IDLE);
    }

}
