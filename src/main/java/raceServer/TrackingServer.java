package raceServer;

import message.AthleteStatusMessage;
import message.DummyMessageProcessor;
import message.Message;
import raceData.Athlete;
import raceData.Client;

import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Observable;

public class TrackingServer extends Observable implements Runnable {

    // Creating an ArrayList of raceData.Athlete

    private ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
    private ArrayList<Client> clients = new ArrayList<>();

    public Communicator getCommunicator() {
        return communicator;
    }

    private Communicator communicator=null;
    private DummyMessageProcessor dummyMessageProcessor=null;


    public TrackingServer(int localPort) throws SocketException, Exception
    {
        communicator = new Communicator(localPort);
        dummyMessageProcessor=new DummyMessageProcessor("raceServer.TrackingServer",this);
        communicator.setProcessor(dummyMessageProcessor);
    }

   /* public void addAthelete(raceData.Athlete ats) {
        this.atheleteList.add(ats);
    }*/

   public void addAthlete(Athlete a)
   {
       athleteList.add(a);
   }

   public void addClient(Client c)
   {
       clients.add(c);
   }

   public void sendToAllClients(Message message)
   {
       sendToClients(message,clients);
   }

   public void addClientsToAthlete(int bibNo, Client c){
       for(Athlete a: athleteList)
       {
           if(a.getBibNumber()==bibNo) {
               a.addClient(c);
               break;
           }
       }
   }

   public void removeClientFromAthlete(int bibNo,int port){
       for(Athlete a: athleteList)
       {
           if(a.getBibNumber()==bibNo) {
               ArrayList<Client> clients=a.getClients();

              for ( Client c: clients)
              {
                  if(c.getPort()==port)
                      a.removeClient(c);

              }
               break;
           }
       }

   }

   public void run() {
       communicator.start();
    }

public Athlete getAthleteByBibNumber(int bibNo)
{
    for(Athlete a: athleteList)
    {
        if(a.getBibNumber()==bibNo) {
            return a;
        }
    }
    return null;
}

public void sendToClients(Message message, ArrayList<Client> clients)
{
    for(Client c: clients)
    {
        try {
            communicator.send(message.toString(), InetAddress.getByName(c.getAddress()),c.getPort());
        } catch (Exception e) {
            System.out.println("Exception :"+e);
        }
    }

}

    public void changeAthleteData(Athlete athlete)
    {
       // for(int i=0; i<athleteList.size();i++)
       // {
        //    if(athleteList.get(i).getBibNumber()==athlete.getBibNumber())
           // {
               // athleteList.set(i,athlete);
                ArrayList<Client> clients= athlete.getClients();
                AthleteStatusMessage message=new AthleteStatusMessage(athlete);
                sendToAllClients(message);


        }

    }

