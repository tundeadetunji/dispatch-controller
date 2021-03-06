package com.example.dispatcher.models;

public class Drone {

    private String DroneSerial;
    private String DroneModel;
    private int DroneWeightLimit;
    private int DroneBatteryCapacity;
    private String DroneState;

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
