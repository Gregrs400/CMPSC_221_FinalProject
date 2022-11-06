package FinalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Airport
{//begin Airport class

    static Random random = new Random();

    public static void main(String[] args)
    {//begin main method

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

        int destinationElement;

        for(int hour = 0; hour < 24; hour++)
        {//begin outer for loop

            for (int min = 0; min < 60; min = min+5)
            {//begin inner for loop

                destinationElement = random.nextInt(alOneDestinations.size());

                airlineOne.generateFlight(airlineOne.airlineFleet.get(0), alOneDestinations.get(destinationElement), hour, min);

            }//end inner for loop

        }//end outer for loop

        int flightsElement = 1;

//        if(airlineOne.flights.get(flightsElement).departureTimeHour < 12)
//            if(airlineOne.flights.get(flightsElement).departureTimeHour == 0) {
//                if (airlineOne.flights.get(flightsElement).departureTimeMin <= 10)
//                {
//                    System.out.println("Flight " + (flightsElement + 1) + " departure time: " + (airlineOne.flights.get(flightsElement).departureTimeHour + 12)
//                            + ":" + 0 + airlineOne.flights.get(flightsElement).departureTimeMin + " AM");
//                }
//                else
//                {
//                    System.out.println("Flight " + (flightsElement + 1) + " departure time: " + (airlineOne.flights.get(flightsElement).departureTimeHour + 12)
//                            + ":" + airlineOne.flights.get(flightsElement).departureTimeMin + " AM");
//                }
//            }
//            else
//            {
//                System.out.println("Flight " + (flightsElement+1) + " departure time: " + airlineOne.flights.get(flightsElement).departureTimeHour
//                        + ":" + airlineOne.flights.get(flightsElement).departureTimeMin + " AM");
//            }
//        else
//        {
//            if(airlineOne.flights.get(flightsElement).departureTimeHour == 12)
//            {
//                System.out.println("Flight " + (flightsElement + 1) + " departure time: " + airlineOne.flights.get(flightsElement).departureTimeHour
//                        + ":" + airlineOne.flights.get(flightsElement).departureTimeMin + " PM");
//            }
//            else
//            {
//                System.out.println("Flight " + (flightsElement + 1) + " departure time: " + (airlineOne.flights.get(flightsElement).departureTimeHour - 12)
//                        + ":" + airlineOne.flights.get(flightsElement).departureTimeMin + " PM");
//            }
//        }
//
//            System.out.println("Destination: " + airlineOne.flights.get(flightsElement).destination);

    }//end main method

}//end Airport class
