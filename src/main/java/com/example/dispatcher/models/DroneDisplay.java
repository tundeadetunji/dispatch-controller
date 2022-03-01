package com.example.dispatcher.models;

public class DroneDisplay {
    private String DroneSerial;
    private String DroneModel;
    private String LaidenOrEmpty;

    public DroneDisplay(String droneSerial, String droneModel, String laidenOrEmpty) {
        DroneSerial = droneSerial;
        DroneModel = droneModel;
        LaidenOrEmpty = laidenOrEmpty;
    }

    public String getDroneSerial() {
        return DroneSerial;
    }

    public String getDroneModel() {
        return DroneModel;
    }

    public String getLaidenOrEmpty() {
        return LaidenOrEmpty;
    }
}
