package com.example.tripsandtramps;

import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private String vehicleNumber;
    private String vehicleBrand;
    private String vehicleType;
    private int numOfSeats;
    private String Availability;
    private double amountForADay;

    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, String vehicleBrand, String vehicleType, int numOfSeats, String availability, double amountForADay) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleBrand = vehicleBrand;
        this.vehicleType = vehicleType;
        this.numOfSeats = numOfSeats;
        Availability = availability;
        this.amountForADay = amountForADay;
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

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public void setAmountForADay(double amountForADay) {
        this.amountForADay = amountForADay;
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

    public String getAvailability() {
        return Availability;
    }

    public double getAmountForADay() {
        return amountForADay;
    }

    public Vehicle createVehicleObject(){
        return null;
    }


}
