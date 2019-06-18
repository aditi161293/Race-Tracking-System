package raceData;

import message.Message;
import raceServer.Communicator;
import raceServer.TrackingServer;

import java.net.InetAddress;
import java.util.Observable;
import java.util.Observer;

public class Client implements Observer{

    public Client (String address, int port){
        this.address=address;
        this.port=port;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private String address;
    private int port;



    @Override
    public void update(Observable o, Object arg) {
        TrackingServer trackingServer=(TrackingServer)o;
        Communicator communicator =trackingServer.getCommunicator();
        Message msg=(Message)arg ;
        try {
            communicator.send(msg.toString(), InetAddress.getByName(address),port);
        } catch (Exception e) {
            System.out.println("Exception : Client update method -->"+e);
        }
    }
}
