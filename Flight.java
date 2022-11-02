package FinalProject;

import java.util.Random;

public class Flight
{

    int departureTime;
    int landingTime;
    int number;
    int flightTime = landingTime-departureTime;
    String destination;

    enum flightStatus
    {

        EARLY,
        ONTIME,
        DELAYED,
        CANCELLED;

    }

    public flightStatus generateStatus()
    {

        Random random = new Random();

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
