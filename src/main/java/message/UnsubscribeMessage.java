package message;

import raceServer.TrackingServer;

public class UnsubscribeMessage extends Message {
    private int athleteBibNumber;
    private String clientAddress;
    private int clientPortNumber;

    public UnsubscribeMessage(){}

    public UnsubscribeMessage(int athleteBibNumber,String clientAddress, int clientPortNumber) {
        this.athleteBibNumber = athleteBibNumber;
        this.clientAddress = clientAddress;
        this.clientPortNumber = clientPortNumber;
    }
    @Override
    public void execute(TrackingServer trackingServer) {

    }
}
