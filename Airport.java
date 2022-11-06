package FinalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Airport
{//begin Airport class

    //Random object used to create flights, picking from the destinations ArrayList randomly
        //declared outside main method to be used in any method
    static Random random = new Random();

    public static void main(String[] args)
    {//begin main method

        //Integer ArrayList flightNumbers to be passed to the Airline class during Airline construction

        ArrayList<Integer> flightNumbers = new ArrayList<>();

        //String ArrayList alOneDestinations, representing the destinations served by Airline One

        ArrayList<String> alOneDestinations = new ArrayList<>();

        //Adding the destinations for Airline One to the alOneDestinations ArrayList

        alOneDestinations.addAll(Arrays.asList("Miami", "Charlotte", "Harrisburg", "Washington DC", "Baltimore", "Jacksonville",
                "Indianapolis", "Fort Lauderdale", "Savannah", "Roanoke", "Detroit", "Tampa", "Atlanta", "Orlando",
                "Los Angeles", "Denver", "San Francisco", "West Palm Beach", "San Jose", "Seattle", "Portland", "Dallas",
                "Austin", "Houston", "Daytona Beach", "Newark", "New York City", "Cincinnati", "Des Moines", "San Diego",
                "Minneapolis", "Phoenix", "Las Vegas", "Boston", "Philadelphia", "Indianapolis", "Nashville", "Chicago",
                "Key West", "New Orleans", "Birmingham", "Albuquerque", "Oklahoma City", "St. Louis", "Kansas City",
                "Milwaukee", "Boise", "San Antonio", "Jackson", "Memphis", "Huntsville", "Fort Meyers", "Louisville",
                "Green Bay"));

        //Creating the Airline object for Airline One, passing the destinations and flightNumbers ArrayLists

        Airline airlineOne = new Airline(alOneDestinations, flightNumbers);

        //creating a plane, plane1, with 50 passenger capacity

        Plane plane1 = new Plane(50);

        //adding plane1 to airlineOne's fleet

        airlineOne.addPlane(plane1);

        //creating a plane, plane2, with 100 passenger capacity

        Plane plane2 = new Plane(100);

        //adding plane2 to airlineOne's fleet

        airlineOne.addPlane(plane2);

        //declaring an int variable for randomly assigning destinations to flights

        for(int hour = 0; hour < 24; hour++)
        {//begin outer for loop

            for (int min = 0; min < 60; min = min+5)
            {//begin inner for loop

                airlineOne.generateFlight(airlineOne.airlineFleet.get(0), hour, min);

            }//end inner for loop

        }//end outer for loop

        int flightsElement = 1;

        airlineOne.printFlight(flightsElement);

    }//end main method

}//end Airport class
