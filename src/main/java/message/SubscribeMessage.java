package message;

import raceData.Athlete;
import raceData.Client;
import raceServer.TrackingServer;

import java.net.InetAddress;

public class SubscribeMessage extends Message {
    private int athleteBibNumber;
    private String clientAddress;
    private int clientPortNumber;


    public SubscribeMessage(){}

    public SubscribeMessage(int athleteBibNumber,String clientAddress, int clientPortNumber){
        this.athleteBibNumber=athleteBibNumber;
        this.clientAddress=clientAddress;
        this.clientPortNumber=clientPortNumber;
    }
    @Override
    public void execute(TrackingServer trackingServer) {
        Client client=new Client(clientAddress,clientPortNumber);
        trackingServer.addClientsToAthlete(athleteBibNumber,client);
    }
}
