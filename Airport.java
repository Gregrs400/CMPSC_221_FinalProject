package FinalProject;

import java.util.ArrayList;
import java.util.Arrays;

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

        Plane plane1 = new Plane(50);

        airlineOne.addPlane(plane1);

        airlineOne.generateFlight(airlineOne.airlineFleet.get(0), "Miami");

        System.out.println("Plane 1 destination: " + airlineOne.flights.get(0).destination);
        System.out.println("Plane 1 flight number: " + airlineOne.flights.get(0).number);

        Plane plane2 = new Plane(100);

        airlineOne.addPlane(plane2);

        airlineOne.generateFlight(airlineOne.airlineFleet.get(1), "Boston");

        System.out.println("\nPlane 2 destination: " + airlineOne.flights.get(1).destination);
        System.out.println("Plane 2 flight number: " + airlineOne.flights.get(1).number);

        airlineOne.flights.get(0).plane.fillPlane(airlineOne.flights.get(0).number);

        airlineOne.flights.get(1).plane.fillPlane(airlineOne.flights.get(1).number);

        System.out.println("\n1st 10 Passengers on Plane 1: \n");

        for(int i = 0; i < airlineOne.flights.get(1).plane.passengers.size(); i++)
        {

            System.out.println(airlineOne.flights.get(1).plane.passengers.get(i).name);

        }

    }

}
