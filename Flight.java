package FinalProject;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;

public class Flight
{

    int departureTime;
    int landingTime;
    int number;
    int flightTime = landingTime-departureTime;
    String destination;

    Random random = new Random();

    ArrayList<String> airlineDestinations = new ArrayList<>();

    Airline al = new Airline();

    public Flight(Airline al, String destination, int number)
    {

        this.al = al;
        this.destination = destination;
        this.number = number;

    }

    public Flight()
    {



    }

    public int generateFlightNumber()
    {



        return number;

    }

    enum flightStatus
    {

        EARLY,
        ONTIME,
        DELAYED,
        CANCELLED;

    }

    public flightStatus generateStatus()
    {

        int flightStatusNum = random.nextInt(4);

        flightStatus fs = flightStatus.ONTIME;

        switch(flightStatusNum)
        {

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

        }

        return fs;

    }

}
