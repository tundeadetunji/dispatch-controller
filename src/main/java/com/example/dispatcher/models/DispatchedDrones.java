package com.example.dispatcher.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class DispatchedDrones {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String DroneSerial = "";

    @Column(nullable = false)
    private String DroneModel = "";

    @Column(nullable = false)
    private int DroneWeightLimit = 500;

    @Column(nullable = false)
    private int DroneBatteryCapacity = 100;

    @Column(nullable = false)
    private String DroneState = "IDLE";

    @Column(nullable = false)
    private String LoadID = "";

    public DispatchedDrones() {
    }

    public DispatchedDrones(String droneSerial, String droneModel, int droneWeightLimit, int droneBatteryCapacity, String droneState, String loadID) {
        DroneSerial = droneSerial;
        DroneModel = droneModel;
        DroneWeightLimit = droneWeightLimit;
        DroneBatteryCapacity = droneBatteryCapacity;
        DroneState = droneState;
        LoadID = loadID;
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

    public String getLoadID() {
        return LoadID;
    }

}
