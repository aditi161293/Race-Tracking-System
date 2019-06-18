package message;

import raceData.Client;
import raceServer.TrackingServer;

public class HelloMessage  extends Message {
    private String clientAddress;
    private int clientPort;
    public HelloMessage()
    {
        clientAddress=null;
        clientPort=0;
    }
    public HelloMessage(String clientAddress, int clientPort)
    {
        this.clientAddress=clientAddress;
        this.clientPort=clientPort;
    }
    @Override
    public void execute(TrackingServer trackingServer) {
        Client c=new Client(clientAddress,clientPort);
        trackingServer.addClient(c);
    }
}
