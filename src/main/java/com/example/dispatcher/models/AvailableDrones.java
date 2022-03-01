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

    public AvailableDrones() {
    }

    public AvailableDrones(String droneSerial, String droneModel) {
        DroneSerial = droneSerial;
        DroneModel = droneModel;
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

}
