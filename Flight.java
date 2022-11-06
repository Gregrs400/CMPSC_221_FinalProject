package FinalProject;

import java.util.*;

public class Flight
{//begin Flight class

    //integer variables which store different times
    int departureTimeHour;
    int departureTimeMin;
    int landingTimeHour;
    int landingTimeMin;
    int flightTimeHour;
    int flightTimeMin;

    //int variable number representing the flight number
    int number;

    //String object destination representing the destination of the flight
    String destination;

    //random object being used to determine the flight status of a flight
        //planning to remove after time is implemented

    Random random = new Random();

    //Plane object being used for Flight parameterized constructor

    Plane plane;

    //Flight parameterized constructor, assigning a plane, a destination, a number, and the departure time of each flight
    public Flight(Plane plane, String destination, int number, int departureTimeHour, int departureTimeMin)
    {//begin Flight parameterized constructor

        this.plane = plane;
        this.destination = destination;
        this.number = number;
        this.departureTimeHour = departureTimeHour;
        this.departureTimeMin = departureTimeMin;

    }//end Flight parameterized constructor

    //flight status enum to assign a flight status depending on the events of the flight
    enum flightStatus
    {//begin flightStatus enum

        EARLY,
        ONTIME,
        DELAYED,
        CANCELLED;

    }//end flightStatus enum

    //generateStatus to assign the enum to the flight

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
