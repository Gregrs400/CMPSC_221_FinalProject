package FinalProject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class Airline {

    ArrayList<String> destinations = new ArrayList<>();

    ArrayList<Integer> flightNumbers = new ArrayList<>();

    ArrayList<Flight> flights = new ArrayList<>();

    ArrayList<Plane> airlineFleet = new ArrayList<>();

    public Airline(ArrayList<String> destinations, ArrayList<Integer> flightNumbers) {

        this.destinations = destinations;
        this.flightNumbers = flightNumbers;

    }

    public Airline() {


    }

    public void addPlane(Plane plane)
    {

        airlineFleet.add(plane);

    }

    public void generateFlight (Plane plane, String destination)
    {
        Random random = new Random();

        int flightNumber = 0;

        do
        {

            flightNumber = random.nextInt(1000)+1;

        }while(flightNumbers.contains(flightNumber));

        flightNumbers.add(flightNumber);

        Flight flight1 = new Flight(plane, destination, flightNumber);

        flights.add(flight1);

    }


}
