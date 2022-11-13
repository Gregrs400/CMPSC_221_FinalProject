package FinalProject;

import java.lang.reflect.Array;
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

        newDay(airlineOne);

        //System.out.println("Rolling stock: " + airlineOne.getRollingStock().size());

//        airlineOne.printFlight(60);
//        airlineOne.printFlight(61);
//        airlineOne.printFlight(62);

    }//end main method

    public static void newDay(Airline airLine)
    {//begin newDay

        Passenger passengerUtility = new Passenger();
        //flight generation loop

        for(int hour = 6; hour < 24; hour++)
        {//begin outer for loop

            for (int min = 0; min < 60; min = min+(random.nextInt(15)+1))
            {//begin inner for loop

                Plane plane = new Plane(airLine.getAirlineFleet().get(0).getPassengerCapacity());
                airLine.generateFlight(plane, hour, min);

            }//end inner for loop

        }//end outer for loop



        ArrayList<Passenger> paxInAirport = new ArrayList<>();

        System.out.println("Flights: " + airLine.getFlights().size());

        paxArrival(airLine, paxInAirport, (airLine.getFlights().size()*50));

        System.out.println("Passengers in Airport: " + paxInAirport.size());

        //actual airport operations loop
        for(int hour = 0; hour < 2; hour++)
        {//begin outer for loop

            for (int min = 0; min < 60; min++)
            {//begin inner for loop

            }//end inner for loop

        }//end outer for loop

        for(int k = 0; k < paxInAirport.size(); k++)
        {//begin for

//            passengerUtility.printPassenger(paxInAirport.get(k));
//
//            System.out.println();

        }//end for

    }//end newDay

    public static ArrayList<Passenger> paxArrival(Airline airline, ArrayList<Passenger> paxInAirport, int pax)
    {

        for (int i = 0; i < pax; i++)
        {//begin inner for loop

                Flight ranFlight;

                do
                {

                    ranFlight = airline.getFlights().get(random.nextInt(airline.getFlights().size()));

                }while(ranFlight.getPlane().isFull());

                Passenger passenger = new Passenger(ranFlight.getNumber(), ranFlight.getDestination(), ranFlight.getNumber() +
                        "_" + (ranFlight.getPlane().getPassengers().size() + 1));

            paxInAirport.add(passenger);

            ranFlight.getPlane().addPaxtoPlane(passenger);

        }//end inner for loop

        return paxInAirport;

    }

}//end Airport class
