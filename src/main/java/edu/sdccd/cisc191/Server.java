package edu.sdccd.cisc191;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //server should listen in on this server socket port
        ServerSocket ss = new ServerSocket(4999);

        //accepts socket
        Socket s = ss.accept();

        //connected message
        System.out.println("Client connected");

        //inStream to receive request
        ObjectInputStream inStream = new ObjectInputStream(s.getInputStream());

        //reads object from InStream and makes a new request and deserialize it
        VehicleRequest receiveRequest = (VehicleRequest)inStream.readObject();

        //request received confirmation
        System.out.println("Vehicle request received.");

        //prints message from vehicle request
        System.out.println(receiveRequest.message);

        //output stream to send out data
        ObjectOutputStream outStream = new ObjectOutputStream(s.getOutputStream());

        //vehicle response which sends to the client
        VehicleResponse vehicleResponse = new VehicleResponse(receiveRequest, 500, 21000, 5, 4, new String[]{"Automatic" , "Tinted Windows"});
        outStream.writeObject(vehicleResponse);
        outStream.flush();

        //close to prevent memory leak
        ss.close();
    }
}