package FinalProject;

import java.util.*;

public class Flight
{//begin Flight class

    int departureTime;
    int landingTime;
    int number;
    int flightTime = landingTime-departureTime;
    String destination;

    Random random = new Random();

    Plane plane;

    public Flight(Plane plane, String destination, int number)
    {//begin Flight parameterized constructor

        this.plane = plane;
        this.destination = destination;
        this.number = number;

    }//end Flight parameterized constructor

    enum flightStatus
    {//begin flightStatus enum

        EARLY,
        ONTIME,
        DELAYED,
        CANCELLED;

    }//end flightStatus enum

    public flightStatus generateStatus()
    {//begin generateStatus

        int flightStatusNum = random.nextInt(4);

        flightStatus fs = flightStatus.ONTIME;

        switch(flightStatusNum)
        {//begin switch

            case 0:
                fs = flightStatus.EARLY;
                break;

            case 1:
                fs = flightStatus.ONTIME;
                break;

            case 2:
                fs = flightStatus.DELAYED;
                break;

            case 3:
                fs = flightStatus.CANCELLED;
                break;

        }//end switch

        return fs;

    }//end generateStatus

}//end flight
