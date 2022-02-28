package com.example.dispatcher.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class AvailableDrones {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String DroneSerial;

    @Column(nullable = false)
    private String DroneModel;

    @Column(nullable = false)
    private int DroneWeightLimit;

    @Column(nullable = false)
    private int DroneBatteryCapacity;

    @Column(nullable = false)
    private String DroneState;

    public AvailableDrones() {
    }

    public AvailableDrones(String droneSerial, String droneModel, int droneWeightLimit, int droneBatteryCapacity, String droneState) {
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
