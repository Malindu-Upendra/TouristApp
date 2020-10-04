package com.example.tripsandtramps;

public class RoomType {

    private String type;
    private int rooms;
    private double amt;

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getType() {
        return type;
    }

    public int getRooms() {
        return rooms;
    }

}
