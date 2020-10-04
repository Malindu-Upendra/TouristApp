package com.example.dashboard;

import java.io.Serializable;

public class Package implements Serializable {

    private String activityName;
    private String tourGuideName;
    private int amount;
    private String location;

    public Package(){}

    public Package(String activityName, String tourGuideName, int amount, String location) {
        this.activityName = activityName;
        this.tourGuideName = tourGuideName;
        this.amount = amount;
        this.location = location;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getTourGuideName() {
        return tourGuideName;
    }

    public void setTourGuideName(String tourGuideName) {
        this.tourGuideName = tourGuideName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
