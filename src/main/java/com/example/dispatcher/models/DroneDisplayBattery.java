package com.example.dispatcher.models;

public class DroneDisplayBattery {
    private String DroneSerial;
    private String DroneModel;
    private int DroneBatteryCapacity;

    public DroneDisplayBattery(String droneSerial, String droneModel, int droneBatteryCapacity) {
        DroneSerial = droneSerial;
        DroneModel = droneModel;
        DroneBatteryCapacity = droneBatteryCapacity;
    }

    public String getDroneSerial() {
        return DroneSerial;
    }

    public String getDroneModel() {
        return DroneModel;
    }

    public int getDroneBatteryCapacity() {
        return DroneBatteryCapacity;
    }
}
