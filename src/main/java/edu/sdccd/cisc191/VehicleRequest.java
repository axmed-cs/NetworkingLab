package edu.sdccd.cisc191;

import java.io.Serializable;

public class VehicleRequest implements Serializable {
    private String make;
    private String model;
    private int year;
    public String message;
    public VehicleRequest(int year, String make, String model){
        this.year = year;
        this.make = make;
        this.model = model;

        //message that holds information of vehicle request
        message = "You have requested a " + year + " " + make + " " + model + ".";
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}