package com.example.dispatcher.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
public class LoadedMedications {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String MedicationCode;

    @Column(nullable = false)
    private String MedicationName = "";

    @Column(nullable = false)
    private int MedicationWeight;

    @Column(nullable = false)
    private String MedicationImageURL = "";

    @Column(nullable = false)
    private String DroneSerial;

    @Column(nullable = false)
    private String DroneModel;

    @Column(nullable = false)
    private String DroneState;

    @Column(nullable = false)
    private Integer DroneId;

    public LoadedMedications() {
    }

    public LoadedMedications(String medicationCode, String medicationName, int medicationWeight, String medicationImageURL, String droneSerial, String droneModel, String droneState, int droneId){
        MedicationCode = medicationCode;
        MedicationWeight = medicationWeight;
        DroneSerial = droneSerial;
        MedicationName = medicationName;
        MedicationImageURL = medicationImageURL;
        DroneModel = droneModel;
        DroneState = droneState;
        DroneId = droneId;
    }

    public String getMedicationCode() {
        return MedicationCode;
    }

    public int getMedicationWeight() {
        return MedicationWeight;
    }

    public String getMedicationName() {
        return MedicationName;
    }

    public String getMedicationImageURL() {
        return MedicationImageURL;
    }

    public String getDroneSerial() {
        return DroneSerial;
    }

    public String getDroneModel() {
        return DroneModel;
    }

    public String getDroneState() {
        return DroneState;
    }

    public Integer getDroneId() {
        return DroneId;
    }
}
