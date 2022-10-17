package edu.sdccd.cisc191;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // client socket with host and port
        Socket s = new Socket("localhost", 4999);

        //output stream for sending out the request
        ObjectOutputStream outStream = new ObjectOutputStream(s.getOutputStream());

        //generates vehicle request
        VehicleRequest vehicleRequest = new VehicleRequest(2021, "Toyota", "Camry" );

        //sends the request out
        outStream.writeObject(vehicleRequest);
        outStream.flush();

        //InStream to receive serialized VehicleResponse
        ObjectInputStream inStream = new ObjectInputStream(s.getInputStream());

        //reads object from InStream (deserializes it) and makes into new vehicle response
        VehicleResponse receiveResponse = (VehicleResponse)inStream.readObject();

        //response received confirmation
        System.out.println("Vehicle response received.");

        //prints message from vehicle response
        System.out.println(receiveResponse.message);

        //close
        outStream.close();
        s.close();
    }
}