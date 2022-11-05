package FinalProject;

import java.util.ArrayList;

public class Airline
{

    ArrayList<String> destinations = new ArrayList<>();

    ArrayList<Integer> flightNumbers = new ArrayList<>();

    ArrayList<Flight> flights = new ArrayList<>();

    public Airline(ArrayList<String> destinations, ArrayList<Integer> flightNumbers)
    {

        this.destinations = destinations;
        this.flightNumbers = flightNumbers;

    }

    public Airline()
    {



    }

}
