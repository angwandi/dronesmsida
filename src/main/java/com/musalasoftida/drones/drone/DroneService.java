package com.musalasoftida.drones.drone;

import com.musalasoftida.drones.medication.Medication;
import com.musalasoftida.drones.medication.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Drone> getDrones(
    ) {
        return droneRepository.findAll();

    }

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
}
