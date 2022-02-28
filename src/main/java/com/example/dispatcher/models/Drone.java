package com.example.dispatcher.models;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Drone {

    //@Id
    private String DroneSerial = "";
    private String DroneModel = "";
    private int DroneWeightLimit = 500;
    private int DroneBatteryCapacity = 100;
    private String DroneState = "IDLE";

    public Drone() {
    }

    public Drone(String droneSerial, String droneModel, int droneWeightLimit, int droneBatteryCapacity, String droneState) {
        DroneSerial = droneSerial;
        DroneModel = droneModel;
        DroneWeightLimit = droneWeightLimit;
        DroneBatteryCapacity = droneBatteryCapacity;
        DroneState = droneState;
    }

    public String getDroneSerial() {
        return DroneSerial;
    }

    public String getDroneModel() {
        return DroneModel;
    }

    public int getDroneWeightLimit() {
        return DroneWeightLimit;
    }

    public int getDroneBatteryCapacity() {
        return DroneBatteryCapacity;
    }

    public String getDroneState() {
        return DroneState;
    }

}
