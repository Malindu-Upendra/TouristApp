package com.example.tripsandtramps;

import java.io.Serializable;
import java.util.Date;


public class Vehicle_Reservation implements Serializable {

    private String key;
    private String vehicleNumber;
    private String vehicleBrand;
    private String vehicleType;
    private int numOfSeats;
    private double finalAmount;
    private Date fromm;
    private Date too;

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Vehicle_Reservation() {
    }

    public Vehicle_Reservation(String vehicleNumber, String vehicleBrand, String vehicleType, int numOfSeats, double finalAmount, Date fromm, Date too) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleBrand = vehicleBrand;
        this.vehicleType = vehicleType;
        this.numOfSeats = numOfSeats;
        this.finalAmount = finalAmount;
        this.fromm = fromm;
        this.too = too;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public void setFromm(Date fromm) {
        this.fromm = fromm;
    }

    public void setToo(Date too) {
        this.too = too;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public Date getFromm() {
        return fromm;
    }

    public Date getToo() {
        return too;
    }
}
