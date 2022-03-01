package com.example.dispatcher.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Drones {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String DroneSerial;

    @Column(nullable = false)
    private String DroneModel;

    @Column(nullable = false)
    private int DroneBatteryCapacity;

    @Column(nullable = false)
    private String DroneState;

    public Drones() {
    }

    public Drones(String droneSerial, String droneModel, int droneBatteryCapacity, String droneState) {
        DroneSerial = droneSerial;
        DroneModel = droneModel;
        DroneBatteryCapacity = droneBatteryCapacity;
        DroneState = droneState;
    }

    public Integer getId() {
        return id;
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

    public String getDroneState() {
        return DroneState;
    }
}
