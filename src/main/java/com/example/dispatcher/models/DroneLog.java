package com.example.dispatcher.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class DroneLog {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String LogTime;

    @Column(nullable = false)
    private Integer DroneId;

    @Column(nullable = false)
    private String DroneSerial;

    @Column(nullable = false)
    private String DroneModel;

    @Column(nullable = false)
    private int DroneBatteryLevel;

    @Column(nullable = false)
    private String Log;

    @Column(nullable = false)
    private String Meta;


    public DroneLog() {
    }

    public DroneLog(String logTime, int droneId, String droneSerial, String droneModel, int droneBatteryLevel, String log, String meta) {
        LogTime=logTime;
        DroneId = droneId;
        DroneSerial = droneSerial;
        DroneModel = droneModel;
        DroneBatteryLevel = droneBatteryLevel;
        Log = log;
        Meta = meta;
    }

    public Integer getId() {
        return id;
    }

    public String getLogTime() {
        return LogTime;
    }

    public int getDroneId() {
        return DroneId;
    }

    public String getDroneSerial() {
        return DroneSerial;
    }

    public String getDroneModel() {
        return DroneModel;
    }

    public int getDroneBatteryLevel() {
        return DroneBatteryLevel;
    }

    public String getLog() {
        return Log;
    }

    public String getMeta() {
        return Meta;
    }
}
