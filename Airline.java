package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Airline
{//begin Airline class

    ArrayList<String> destinations = new ArrayList<>();

    ArrayList<Integer> flightNumbers = new ArrayList<>();

    ArrayList<Flight> flights = new ArrayList<>();

    ArrayList<Plane> airlineFleet = new ArrayList<>();

    public Airline(ArrayList<String> destinations, ArrayList<Integer> flightNumbers)
    {//begin Airline parameterized constructor

        this.destinations = destinations;
        this.flightNumbers = flightNumbers;

    }//end Airline parameterized constructor

    public Airline()
    {//begin Airline default no args constructor


    }//end Airline default no args constructor

    public void addPlane(Plane plane)
    {//begin addPlane

        airlineFleet.add(plane);

    }//end addPlane

    public void generateFlight (Plane plane, String destination)
    {//begin generateFlight

        Random random = new Random();

        int flightNumber = 0;

        do
        {//begin do-while loop

            flightNumber = random.nextInt(1000)+1;

        }while(flightNumbers.contains(flightNumber)); //end do-while loop

        flightNumbers.add(flightNumber);

        Flight flight1 = new Flight(plane, destination, flightNumber);

        flights.add(flight1);

    }


}
