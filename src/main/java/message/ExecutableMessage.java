package message;

import raceServer.TrackingServer;

public interface ExecutableMessage {
    public void execute(TrackingServer trackingServer);
}
