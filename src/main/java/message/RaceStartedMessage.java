package message;

import raceServer.TrackingServer;

public class RaceStartedMessage extends Message {
    private String raceName;
    private int courseLength;
    public RaceStartedMessage()
    {

    }
    public RaceStartedMessage(String raceName, int courseLength)
    {
        this.courseLength=courseLength;
        this.raceName=raceName;
        System.out.println("i am in RaceStatrtedMessage constructor");
    }
    @Override
    public void execute(TrackingServer trackingServer) {
        System.out.println("i am in RaceStatrtedMessage execute Method");

        trackingServer.sendToAllClients(this);
    }

    @Override
    public String toString() {
        System.out.println("i am in RaceStatrtedMessage toString");
        return "Race,"+raceName+","+String.valueOf(courseLength);
    }
}

