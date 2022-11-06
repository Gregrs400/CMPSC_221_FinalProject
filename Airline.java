package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Airline
{//begin Airline class

    //String ArrayList of destinations offered by an airline from this airport

    ArrayList<String> destinations = new ArrayList<>();

    //Integer ArrayList of Flight Numbers of flights created by the airline

    ArrayList<Integer> flightNumbers = new ArrayList<>();

    //Flight object ArrayList storing the flights created by the airline

    ArrayList<Flight> flights = new ArrayList<>();

    //Plane object ArrayList storing the planes in an airline's fleet

    ArrayList<Plane> airlineFleet = new ArrayList<>();

    //Airline parameterized constructor

    public Airline(ArrayList<String> destinations, ArrayList<Integer> flightNumbers)
    {//begin Airline parameterized constructor

        this.destinations = destinations;
        this.flightNumbers = flightNumbers;

    }//end Airline parameterized constructor

    //Airline default constructor

    public Airline()
    {//begin Airline default no args constructor


    }//end Airline default no args constructor

    //addPlane to add a plane to an airline's fleet
    public void addPlane(Plane plane)
    {//begin addPlane

        airlineFleet.add(plane);

    }//end addPlane

    //generateFlight to create a flight for an airline, assigning each flight a plane, a destination, a flight number, and a departure time

    public void generateFlight (Plane plane, String destination, int departHour, int departMin)
    {//begin generateFlight

        Random random = new Random();

        int flightNumber = 0;

        //do-while loop to ensure each flight number is unique

        do
        {//begin do-while loop

            flightNumber = random.nextInt(999)+1;

        }while(flightNumbers.contains(flightNumber)); //end do-while loop

        flightNumbers.add(flightNumber);

        Flight flight1 = new Flight(plane, destination, flightNumber, departHour, departMin);

        flights.add(flight1);

    }


}
