package edu.sdccd.cisc191;

import java.io.Serializable;
import java.util.Arrays;

public class VehicleResponse implements Serializable {
    private VehicleRequest request;
    private int price;
    private int numberOfDoors;
    private int numberOfSeats;
    private int milesOnVehicle;
    private String[] options;
    public String message;

    public VehicleResponse(VehicleRequest request, int milesOnVehicle, int price, int numberOfSeats, int numberOfDoors, String[] options) {
        this.request = request;
        this.milesOnVehicle = milesOnVehicle;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.options = options;

        //message from response that shows vehicle information
        message = request.message + " This vehicle includes " + milesOnVehicle + " miles, "
                + numberOfSeats + " seats, " + numberOfDoors + " doors, and the cost is " + price + ". "
                + "This Vehicle has these options: " + Arrays.toString(options) + ".";
    }
}