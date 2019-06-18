package message;

import raceData.Athlete;
import raceServer.TrackingServer;

public class AthleteStatusMessage extends Message {

    private Athlete athlete;


    public AthleteStatusMessage(Athlete athlete) {
        this.athlete = athlete;
    }


    @Override
    public String toString() {
        System.out.println("Status,"+athlete.getBibNumber()+","+athlete.getStatus()+","+athlete.getStart_Time()+","
                +athlete.getDistance_Covered()+","+athlete.getLast_Updated_Time()+","+athlete.getFinish_Time());
        return "Status,"+athlete.getBibNumber()+","+athlete.getStatus()+","+athlete.getStart_Time()+","
                +athlete.getDistance_Covered()+","+athlete.getLast_Updated_Time()+","+athlete.getFinish_Time();
    }
}
