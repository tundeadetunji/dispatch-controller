package com.example.dispatcher.controllers;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Request;

import com.example.dispatcher.Check;
import com.example.dispatcher.CheckBattery;
import com.example.dispatcher.Drone;
import com.example.dispatcher.Load;
import com.example.dispatcher.models.*;
//import com.example.dispatcher.models.Drone;
import com.example.dispatcher.repository.AvailableDronesRepository;
import com.example.dispatcher.repository.DronesRepository;
import com.example.dispatcher.repository.LoadedMedicationsRepository;
import com.example.dispatcher.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import static com.example.support.Support.*;

@Component
@Path("/drones")
@Consumes("application/json")
@Produces("application/json")
public class DronesController {

    @Autowired
    private ApplicationContext context;

    @GET
    @Path("/check-battery")
    public ResponseEntity<Object> checkBattery(@RequestBody CheckBattery checkBattery) {

        DronesRepository dronesRepository = context.getBean(DronesRepository.class);
        int id = checkBattery.getId();
        Optional<Drones> drone = dronesRepository.findById(id);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(drone);
        //returns empty object if not found

    }


    @GET
    @Path("/check-available")
    public ResponseEntity<Object> checkAvailable() {
        LoadedMedicationsRepository loadedMedicationsRepository = context.getBean(LoadedMedicationsRepository.class);
        AvailableDronesRepository availableDronesRepository = context.getBean(AvailableDronesRepository.class);


        //available
        List<String> serials_a = new ArrayList<>();
        List<DroneCheck> checks_a = new ArrayList<>();
        Iterable<AvailableDrones> availableDronesIterable = availableDronesRepository.findAll();
        Iterator<AvailableDrones> availableDronesIterator = availableDronesIterable.iterator();
        while (availableDronesIterator.hasNext()) {
            AvailableDrones availableDrone = availableDronesIterator.next();
            if (serials_a != null && serials_a.size() > 0) {
                if (serials_a.contains(availableDrone.getDroneSerial()) == false) {
                    serials_a.add(availableDrone.getDroneSerial());
                    DroneCheck droneCheckA = new DroneCheck(availableDrone.getDroneSerial(), availableDrone.getDroneModel());
                    checks_a.add(droneCheckA);
                }
            } else if (serials_a != null) {
                serials_a.add(availableDrone.getDroneSerial());
                DroneCheck droneCheckAM = new DroneCheck(availableDrone.getDroneSerial(), availableDrone.getDroneModel());
                checks_a.add(droneCheckAM);
            }
        }


        //laiden
        List<String> serials_m = new ArrayList<>();
        List<DroneCheck> checks_m = new ArrayList<>();
        Iterable<LoadedMedications> loadedMedicationsIterable = loadedMedicationsRepository.findAll();
        Iterator<LoadedMedications> loadedMedicationsIterator = loadedMedicationsIterable.iterator();

        while (loadedMedicationsIterator.hasNext()) {
            LoadedMedications loadedMedication = loadedMedicationsIterator.next();
            if (serials_m != null && serials_m.size() > 0) {
                if (serials_m.contains(loadedMedication.getDroneSerial()) == false) {
                    serials_m.add(loadedMedication.getDroneSerial());
                    DroneCheck droneCheck = new DroneCheck(loadedMedication.getDroneSerial(), loadedMedication.getDroneModel());
                    checks_m.add(droneCheck);
                }
            } else if (serials_m != null) {
                serials_m.add(loadedMedication.getDroneSerial());
                DroneCheck droneCheckM = new DroneCheck(loadedMedication.getDroneSerial(), loadedMedication.getDroneModel());
                checks_m.add(droneCheckM);
            }
        }


        //add to final list
        List<DroneDisplay> list = new ArrayList<>();

        //free
        Iterator<DroneCheck> leftIterator = checks_a.iterator();
        while ((leftIterator.hasNext())) {
            DroneCheck droneCheckLeft = leftIterator.next();
            DroneDisplay displayLeft = new DroneDisplay(droneCheckLeft.getDroneSerial(), droneCheckLeft.getDroneModel(), "EMPTY");
            list.add(displayLeft);
        }


        //laiden
        Iterator<DroneCheck> rightIterator = checks_m.iterator();
        while (rightIterator.hasNext()) {
            DroneCheck droneCheckM = rightIterator.next();
            DroneDisplay displayM = new DroneDisplay(droneCheckM.getDroneSerial(), droneCheckM.getDroneModel(), "LAIDEN");
            list.add(displayM);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);

    }

    @GET
    @Path("/check-load")
    public ResponseEntity<Object> checkLoad(@RequestBody Check check) {
        String error_message = "";
        HttpStatus status = HttpStatus.ACCEPTED;
        boolean ok = true;

        if (check == null) {
            error_message = "No Serial Number to check against.";
            status = HttpStatus.NO_CONTENT;
            ok = false;
        }

        boolean droneExists = false;
        String drone_serial = String.valueOf(check.getDroneSerial());

        DronesRepository dronesRepository = context.getBean(DronesRepository.class);
        LoadedMedicationsRepository loadedMedicationsRepository = context.getBean(LoadedMedicationsRepository.class);

        //checking if drone exists
        Iterable<Drones> dronesIterable = dronesRepository.findAll();
        Iterator<Drones> dronesIterator = dronesIterable.iterator();
        while (dronesIterator.hasNext()) {
            Drones drone = dronesIterator.next();
            if (drone.getDroneSerial().equals(drone_serial)) {
                //found it
                droneExists = true;
            }
        }
        if (droneExists == false) {
            error_message = "This drone does not exist.";
            status = HttpStatus.BAD_REQUEST;
            ok = false;
        }

        Iterable<LoadedMedications> loadedMedicationsIterable = loadedMedicationsRepository.findAll();
        Iterator<LoadedMedications> loadedMedicationsIterator = loadedMedicationsIterable.iterator();
        List<LoadedMedications> list = new ArrayList<>();
        while (loadedMedicationsIterator.hasNext()) {
            LoadedMedications loadedMedication = loadedMedicationsIterator.next();
            if (loadedMedication.getDroneSerial().equals(drone_serial)) {
                list.add(loadedMedication);
            }
        }

        if (ok == true) {

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
        } else {
            return ResponseEntity.status(status).body(error_message);
        }

    }

    @POST
    @Path("/load")
    public ResponseEntity<Object> loadDrone(@RequestBody Load load) {
        String error_message = "";
        HttpStatus status = HttpStatus.ACCEPTED;
        boolean ok = true;

        if (load == null) {
            error_message = "Nothing to load.";
            status = HttpStatus.NO_CONTENT;
            ok = false;
        }

        boolean droneExists = false;
        boolean medExists = false;

        String drone_serial = String.valueOf(load.getDroneSerial());
        int drone_id = load.getDroneId();
        String medication_code = String.valueOf(load.getMedicationCode());
        String medication_name = "";
        String medication_image_url = "";
        String drone_model = "";
        String drone_state = "";

        int battery_level = 100;
        int current_weight = 0;

        DronesRepository dronesRepository = context.getBean(DronesRepository.class);
        MedicationRepository medicationRepository = context.getBean(MedicationRepository.class);
        LoadedMedicationsRepository loadedMedicationsRepository = context.getBean(LoadedMedicationsRepository.class);
        AvailableDronesRepository availableDronesRepository = context.getBean(AvailableDronesRepository.class);

        //checking if medication exists
        Iterable<Medication> medicationIterable = medicationRepository.findAll();
        Iterator<Medication> medicationIterator = medicationIterable.iterator();
        while (medicationIterator.hasNext()) {
            Medication med = medicationIterator.next();
            if (med.getMedicationCode().equals(medication_code)) {
                medExists = true;
                current_weight = med.getMedicationWeight();
                medication_name = med.getMedicationName();
                medication_image_url = med.getMedicationImageURL();

            }
        }
        if (!medExists) {
            error_message = "This medication code appears to be wrong.";
            status = HttpStatus.BAD_REQUEST;
            ok = false;
        }


        //checking if drone exists
        Iterable<Drones> dronesIterable = dronesRepository.findAll();
        Iterator<Drones> dronesIterator = dronesIterable.iterator();
        while (dronesIterator.hasNext()) {
            Drones drone = dronesIterator.next();
            if (drone.getDroneSerial().equals(drone_serial)) {
                //found it
                droneExists = true;
                battery_level = drone.getDroneBatteryCapacity();
                drone_model = drone.getDroneModel();
                drone_state = drone.getDroneState();
            }
        }
        if (droneExists == false) {
            error_message = "This drone does not exist.";
            status = HttpStatus.BAD_REQUEST;
            ok = false;
        }

        //checking if battery level is >=25
        if (battery_level < 25) {
            error_message = "This drone cannot be loaded because the battery level is below 25%.";
            status = HttpStatus.BAD_REQUEST;
            ok = false;
        }

        //checking if, wherever drone_serial matches, weight to add + accumulated weight <= drone's weight limit of 500
        int accumulated_weight = 0;

        Iterable<LoadedMedications> loadedMedicationsIterable = loadedMedicationsRepository.findAll();
        Iterator<LoadedMedications> loadedMedicationsIterator = loadedMedicationsIterable.iterator();
        while (loadedMedicationsIterator.hasNext()) {
            LoadedMedications loadedMedication = loadedMedicationsIterator.next();
            if (loadedMedication.getDroneSerial().equals(drone_serial)) {
                accumulated_weight = loadedMedication.getMedicationWeight();
            }
        }

        if ((accumulated_weight + current_weight) > 500) {
            error_message = "This drone cannot be loaded because the weight you're attempting to put on board plus the weight already on board is more than the weight limit of 500g.";
            status = HttpStatus.BAD_REQUEST;
            ok = false;
        }

        if (ok == true) {
            LoadedMedications medication = new LoadedMedications(medication_code, medication_name, current_weight, medication_image_url, drone_serial, drone_model, drone_state, drone_id);
            loadedMedicationsRepository.save(medication);

            if (availableDronesRepository.findById(drone_id) != null) {
                availableDronesRepository.deleteById(drone_id);
            }

//            try{
//            }
//            catch (Exception e){
//
//            }

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(medication);
        } else {
            return ResponseEntity.status(status).body(error_message);
        }

    }


    @POST
    @Path("/new")
    public ResponseEntity<Object> newDrone(@RequestBody Drone drone) {

        String error_message = "";
        HttpStatus status = HttpStatus.ACCEPTED;
        boolean ok = true;

        if (drone == null) {
            error_message = "The details of the drone was not supplied.";
            status = HttpStatus.NO_CONTENT;
            ok = false;
        }

        String serial = drone.getDroneSerial();
        String model = drone.getDroneModel();

        //check if serial's number of characters is within limit of 100
        if (String.valueOf(serial).length() > 100) {
            error_message = "Serial should not be more than 100 characters long.";
            status = HttpStatus.BAD_REQUEST;
            ok = false;
        }

        //checking if model is acceptable
        if ((!model.toLowerCase().equals("lightweight")) && (!model.toLowerCase().equals("middleweight"))
                && (!model.toLowerCase().equals("heavyweight")) && (!model.toLowerCase().equals("cruiserweight"))) {
            error_message = "Model can only be Lightweight, Middleweight, Cruiserweight or Heavyweight.";
            status = HttpStatus.BAD_REQUEST;
            ok = false;
        }


        if (ok == true) {
            //new
            DronesRepository dronesRepository = context.getBean(DronesRepository.class);

            Drones new_drone = new Drones(drone.getDroneSerial(), drone.getDroneModel(), 100, DRONE_STATE.IDLE.toString());
            dronesRepository.save(new_drone);

            //available
            AvailableDronesRepository availableDronesRepository = context.getBean(AvailableDronesRepository.class);

            AvailableDrones idle_drone = new AvailableDrones(drone.getDroneSerial(), drone.getDroneModel());
            availableDronesRepository.save(idle_drone);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new_drone);
        } else {
            return ResponseEntity.status(status).body(error_message);
        }

    }

}
