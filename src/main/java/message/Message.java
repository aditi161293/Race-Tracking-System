package message;

import raceServer.TrackingServer;

public class Message {

    ExecutableMessage executableMessages;

       public  void execute(TrackingServer trackingServer)
       {
           executableMessages.execute(trackingServer);
       }



        public static Message createObject(String message)
        {
            String [] params= message.split(",");

            String messageName=params[0];
                Message result=null;
                if(messageName.equals("Hello"))
                {
                    return new HelloMessage(params[1],Integer.parseInt(params[2]));
                }
                if(messageName.equals("Subscribe"))
                {
                    return new SubscribeMessage(Integer.parseInt(params[1]),params[2],Integer.parseInt(params[3]));
                }
                if(messageName.equals("Subscribe"))
                {
                return new UnsubscribeMessage(Integer.parseInt(params[1]),params[2],Integer.parseInt(params[3]));
                }

                if(messageName.equals("Race")) {
                    System.out.println("i am in message if loop");
                    return new RaceStartedMessage(params[1],Integer.parseInt(params[2]));
                }
                if(messageName.equals("Registered")) {
                        result= new RegisteredMessage(Integer.parseInt(params[1]),Integer.parseInt(params[2]),params[3],params[4],params[5],Integer.parseInt(params[6]));
                }
                if(messageName.equals("DidNotStart")) {
                        result= new DidNotStartMessage(Integer.parseInt(params[1]),Integer.parseInt(params[2]));
                }
                if(messageName.equals("Started")) {
                result= new StartedUpdateMessage(Integer.parseInt(params[1]),Integer.parseInt(params[2]));
                }

                if(messageName.equals("OnCourse")) {
                result= new OnCourseUpdateMessage(Integer.parseInt(params[1]),Integer.parseInt(params[2]),Double.parseDouble(params[3]));
                }

                if(messageName.equals("DidNotFinish")) {
                result= new DidNotFinishMessage(Integer.parseInt(params[1]),Integer.parseInt(params[2]));
               }

            if(messageName.equals("Finished")) {
                result= new FinishedUpdateMessage(Integer.parseInt(params[1]),Integer.parseInt(params[2]));
            }

                return result;


        }





}
