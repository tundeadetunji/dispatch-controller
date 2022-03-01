package com.example.dispatcher.models;

public class DroneCheck {
    private String DroneSerial;
    private String DroneModel;

    public DroneCheck() {
    }

    public DroneCheck(String droneSerial, String droneModel) {
        DroneSerial = droneSerial;
        DroneModel = droneModel;
    }

    public String getDroneSerial() {
        return DroneSerial;
    }

    public String getDroneModel() {
        return DroneModel;
    }

}
