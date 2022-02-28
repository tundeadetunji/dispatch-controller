package com.example.dispatcher.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
public class LoadedMedication {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String MedicationCode = "";

    @Column(nullable = false)
    private String MedicationName = "";

    @Column(nullable = false)
    private int MedicationWeight = 0;

    @Column(nullable = false)
    private String MedicationImageURL = "";

    @Column(nullable = false)
    private String DroneSerial = "";

    @Column(nullable = false)
    private String LoadID = "";

    public LoadedMedication() {
    }

    public LoadedMedication(String medicationCode, String medicationName, int medicationWeight, String medicationImageURL, String droneSerial, String loadID) {
        MedicationCode = medicationCode;
        MedicationName = medicationName;
        MedicationWeight = medicationWeight;
        MedicationImageURL = medicationImageURL;
        DroneSerial = droneSerial;
        LoadID = loadID;
    }

    public String getMedicationCode() {
        return MedicationCode;
    }

    public String getMedicationName() {
        return MedicationName;
    }

    public int getMedicationWeight() {
        return MedicationWeight;
    }

    public String getMedicationImageURL() {
        return MedicationImageURL;
    }

    public String getDroneSerial() {
        return DroneSerial;
    }

    public String getLoadID() {
        return LoadID;
    }

}
