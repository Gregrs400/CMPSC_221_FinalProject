package FinalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Airport
{

    public static void main(String[] args) {

        Passenger pax1 = new Passenger();

        pax1.name = "name";

        ArrayList<Integer> flightNumbers = new ArrayList<>();

        ArrayList<String> alOneDestinations = new ArrayList<>();

        alOneDestinations.addAll(Arrays.asList("Miami", "Charlotte", "Harrisburg", "Washington DC", "Baltimore", "Jacksonville",
                "Indianapolis", "Fort Lauderdale", "Savannah", "Roanoke", "Detroit", "Tampa", "Atlanta", "Orlando",
                "Los Angeles", "Denver", "San Francisco", "West Palm Beach", "San Jose", "Seattle", "Portland", "Dallas",
                "Austin", "Houston", "Daytona Beach", "Newark", "New York City", "Cincinnati", "Des Moines", "San Diego",
                "Minneapolis", "Phoenix", "Las Vegas", "Boston", "Philadelphia", "Indianapolis", "Nashville", "Chicago",
                "Key West", "New Orleans", "Birmingham", "Albuquerque", "Oklahoma City", "St. Louis", "Kansas City",
                "Milwaukee", "Boise", "San Antonio", "Jackson", "Memphis", "Huntsville", "Fort Meyers", "Louisville",
                "Green Bay"));

        Airline airlineOne = new Airline(alOneDestinations, flightNumbers);

        for(int i = 0; i < airlineOne.destinations.size(); i++)
        {

            Flight flight = generateFlight(airlineOne, airlineOne.destinations.get(i));

            airlineOne.flights.add(flight);

        }

        //System.out.println(flight1.generateStatus());

        Plane plane1 = new Plane();

        //plane1.fillPlane();

        for(int j = 0; j < airlineOne.flights.size(); j++)
        {

            System.out.println("Flight Number: " + airlineOne.flights.get(j).number);
            System.out.println("Destination: " + airlineOne.flights.get(j).destination + "\n");

        }

    }

    public static Flight generateFlight(Airline aL, String destination)
    {
        Random random = new Random();

        int flightNumber = 0;

        do
        {

            flightNumber = random.nextInt(1000)+1;

        }while(aL.flightNumbers.contains(flightNumber));

        aL.flightNumbers.add(flightNumber);

        Flight flight1 = new Flight(aL, destination, flightNumber);

        return flight1;

    }

}
