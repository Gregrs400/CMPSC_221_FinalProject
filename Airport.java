package FinalProject;

import java.util.ArrayList;
import java.util.Arrays;

public class Airport
{//begin Airport class

    public static void main(String[] args)
    {//begin main method

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

        Plane plane2 = new Plane(100);

        airlineOne.addPlane(plane2);

        System.out.println("Start of Loop");

        for(int j = 0; j < alOneDestinations.size(); j++)
        {//begin for loop

            airlineOne.generateFlight(airlineOne.airlineFleet.get(0), alOneDestinations.get(j));

            airlineOne.flights.get(j).plane.fillPlane(airlineOne.flights.get(j).number);

        }//end for loop

        System.out.println(airlineOne.flights.get(4).number);

    }//end main method

}//end Airport class
