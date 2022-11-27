package FinalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Airport
{//begin Airport class

    //Random object used to create flights, picking from the destinations ArrayList randomly
        //declared outside main method to be used in any method

    static Random random = new Random();

    static ArrayList<ArrayList<ArrayList<String>>> destMap = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> flightTimes = new ArrayList<>();

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
                "Minneapolis", "Phoenix", "Las Vegas", "Boston", "Philadelphia", "Nashville", "Chicago",
                "Key West", "New Orleans", "Birmingham", "Albuquerque", "Oklahoma City", "St. Louis", "Kansas City",
                "Milwaukee", "Boise", "San Antonio", "Jackson", "Memphis", "Huntsville", "Fort Meyers", "Louisville",
                "Green Bay"));

        //Creating the Airline object for Airline One, passing the destinations and flightNumbers ArrayLists

        Airline airlineOne = new Airline(alOneDestinations, flightNumbers);

        //determining location of airport and making flight times to other airports

        for(int i = 0; i < 9; i++) {

            destMap.add(new ArrayList<ArrayList<String>>());

            for(int j = 0; j < 16; j++)
            {

                destMap.get(i).add(new ArrayList<String>());

            }

        }

        fillDestMap(destMap);

        String airportLocation = "Philadelphia";

        int[] originCoords = findAirportCoords(airportLocation);

        airlineOne.removeFromDestinations(airportLocation);

        int[] mapSize = {destMap.size(), destMap.get(0).size()};

        generateFlightTimesAL(originCoords, mapSize);

        //creating a plane, plane1, with 50 passenger capacity

        Plane plane1 = new Plane(50);

        //adding plane1 to airlineOne's fleet

        airlineOne.addPlane(plane1);

        //creating a plane, plane2, with 100 passenger capacity

        Plane plane2 = new Plane(100);

        //adding plane2 to airlineOne's fleet

        airlineOne.addPlane(plane2);

        ArrayList<Passenger> paxInAirport = new ArrayList<>();

        newDay(airlineOne, paxInAirport);

        //airlineOne.printPaxWithSameDest("Washington DC");

        airlineOne.getFlights().get(2).printFlight();

        //airlineOne.printFlight(1);

    }//end main method

    public static void newDay(Airline airLine, ArrayList<Passenger> paxInAirport)
    {//begin newDay

        //Passenger class object for accessing and updating passengers

        Passenger passengerUtility;

        //flight generation loop

        for (int min = 600; min < 900; min = min+(random.nextInt(15)+1))
        {//begin flight generation loop

                Plane plane = new Plane(airLine.getAirlineFleet().get(0).getPassengerCapacity());

                Flight flight = airLine.generateFlight(plane, getHour(min), getMin(min), min);

                int flightTime = generateLandingTime(flight.getDestination());

                flight.setFlightTime(flightTime);

                int landingTime = ((flight.getDepartureTime())+flightTime);

                flight.setLandingTime(landingTime);

                flight.setLandingTimeHour(getHour(landingTime));

                flight.setLandingTimeMin(getMin(landingTime));

                plane.setFlight(flight);

                plane.setFlightTimes(flightTime);

        }//end flight generation loop

        System.out.println("Flights: " + airLine.getFlights().size() + "\n");

        airLine.getFlights().get(2).getPlane().setPrint(true);

        //actual airport operations loop

        int paxGenerated, paxBeingGenerated;

        paxGenerated = 0;

        paxBeingGenerated = 10;

        for (int min = 0; min < 1440; min++)
        {//begin outer for loop

            if(paxGenerated < (airLine.getFlights().size() * 50))
            {//begin passenger arrival iterator

                paxArrival(airLine, paxInAirport, paxBeingGenerated);

                paxGenerated += paxBeingGenerated;

            }//end passenger arrival iterator

            if(paxInAirport.size() > 0)
            {//begin if passengers are in airport

                for (int paxElement = 0; paxElement < paxInAirport.size(); paxElement++)
                {//begin passenger status updater

                    passengerUtility = paxInAirport.get(paxElement);

                    Flight paxFlight = airLine.paxFlightFromNum(passengerUtility);

                    if (!(passengerUtility.isAtGate()))
                    {//begin passenger time updater

                        passengerUtility.movePassenger();

                    }//end passenger time updater

                    if (passengerUtility.isAtGate() && (min < paxFlight.getDepartureTime() - 15))
                    {//begin if passenger can board plane

                        paxFlight.getPlane().addPaxToPlane(passengerUtility);
                        paxInAirport.remove(passengerUtility);

                    }//end if passenger can board plane

                }//end passenger status updater

            }//end if passengers are in airport

            for(Flight flight : airLine.getFlights())
            {

                if(flight.getDepartureTime() == min)
                {

                    flight.getPlane().ps = Plane.planeStatus.READY_TO_TAXI;
                    flight.getPlane().movePlane();

                }

                if(min > flight.getDepartureTime() && (!(flight.getPlane().ps.equals(Plane.planeStatus.AT_GATE))))
                {

                    flight.getPlane().movePlane();

                }

            }

        }//end outer for loop

    }//end newDay

    public static void paxArrival(Airline airline, ArrayList<Passenger> paxInAirport, int pax)
    {

        for (int i = 0; i < pax; i++)
        {//begin inner for loop

                Flight ranFlight;

                do
                {

                    ranFlight = airline.getFlights().get(random.nextInt(airline.getFlights().size()));

                }while(ranFlight.isSoldOut());

                Passenger passenger = new Passenger(ranFlight.getNumber(), ranFlight.getDestination(), (ranFlight.getNumber() +
                        "_" + (ranFlight.getPaxWithTickets().size() + 1)), ranFlight.getGate());


            paxInAirport.add(passenger);

            ranFlight.getPaxWithTickets().add(passenger);

        }//end inner for loop

    }

    public static int getHour(int minutes){return minutes / 60;}

    public static int getMin(int minutes){return minutes % 60;}

    public static void fillDestMap(ArrayList<ArrayList<ArrayList<String>>> destMap)
    {//begin fillDestMap

        // "Miami", "Charlotte", "Harrisburg", "Washington DC", "Baltimore", "Jacksonville",

        destMap.get(8).get(12).add("Miami");
        destMap.get(5).get(12).add("Charlotte");
        destMap.get(3).get(13).add("Harrisburg");
        destMap.get(4).get(13).add("Washington DC");
        destMap.get(4).get(13).add("Baltimore");
        destMap.get(8).get(12).add("Jacksonville");

        // "Indianapolis", "Fort Lauderdale", "Savannah", "Roanoke", "Detroit", "Tampa", "Atlanta", "Orlando",

        destMap.get(4).get(11).add("Indianapolis");
        destMap.get(8).get(12).add("Fort Lauderdale");
        destMap.get(7).get(12).add("Savannah");
        destMap.get(4).get(12).add("Roanoke");
        destMap.get(3).get(11).add("Detroit");
        destMap.get(7).get(12).add("Tampa");
        destMap.get(6).get(11).add("Atlanta");
        destMap.get(7).get(12).add("Orlando");

        // "Los Angeles", "Denver", "San Francisco", "West Palm Beach", "San Jose", "Seattle", "Portland", "Dallas",

        destMap.get(6).get(2).add("Los Angeles");
        destMap.get(4).get(5).add("Denver");
        destMap.get(4).get(0).add("San Francisco");
        destMap.get(8).get(12).add("West Palm Beach");
        destMap.get(4).get(1).add("San Jose");
        destMap.get(1).get(1).add("Seattle");
        destMap.get(1).get(0).add("Portland");
        destMap.get(6).get(8).add("Dallas");

        // "Austin", "Houston", "Daytona Beach", "Newark", "New York City", "Cincinnati", "Des Moines", "San Diego",

        destMap.get(7).get(7).add("Austin");
        destMap.get(7).get(8).add("Houston");
        destMap.get(7).get(12).add("Daytona Beach");
        destMap.get(3).get(14).add("Newark");
        destMap.get(3).get(14).add("New York City");
        destMap.get(4).get(11).add("Cincinnati");
        destMap.get(3).get(8).add("Des Moines");
        destMap.get(6).get(2).add("San Diego");

        // "Minneapolis", "Phoenix", "Las Vegas", "Boston", "Philadelphia", "Nashville", "Chicago",

        destMap.get(2).get(9).add("Minneapolis");
        destMap.get(6).get(3).add("Phoenix");
        destMap.get(5).get(3).add("Las Vegas");
        destMap.get(3).get(15).add("Boston");
        destMap.get(3).get(13).add("Philadelphia");
        destMap.get(5).get(10).add("Nashville");
        destMap.get(3).get(10).add("Chicago");

        // "Key West", "New Orleans", "Birmingham", "Albuquerque", "Oklahoma City", "St. Louis", "Kansas City",

        destMap.get(8).get(12).add("Key West");
        destMap.get(7).get(9).add("New Orleans");
        destMap.get(6).get(10).add("Birmingham");
        destMap.get(5).get(5).add("Albuquerque");
        destMap.get(5).get(7).add("Oklahoma City");
        destMap.get(4).get(9).add("St. Louis");
        destMap.get(4).get(8).add("Kansas City");

        // "Milwaukee", "Boise", "San Antonio", "Jackson", "Memphis", "Huntsville", "Fort Meyers", "Louisville",

        destMap.get(2).get(10).add("Milwaukee");
        destMap.get(2).get(2).add("Boise");
        destMap.get(6).get(9).add("Jackson");
        destMap.get(5).get(9).add("Memphis");
        destMap.get(5).get(10).add("Huntsville");
        destMap.get(8).get(12).add("Fort Meyers");
        destMap.get(4).get(11).add("Louisville");

        // "Green Bay"

        destMap.get(2).get(10).add("Green Bay");
    }//end fillDestMap

    public static int[] findAirportCoords(String city)
    {

        int[] airportCoords = new int[2];

        int destRow = -1;
        int destColumn = -1;

        int row = 0;
        int column = 0;

        do
        {
             column = 0;
            do
            {

                if(destMap.get(row).get(column).contains(city))
                {

                    destRow = row;
                    destColumn = column;

                    airportCoords[0] = row;
                    airportCoords[1] = column;

                }

                column++;
            }while(destColumn == -1 && column < destMap.get(row).size());

            row++;
        }while(destRow == -1 && row < destMap.size());

        return airportCoords;

    }

    public static int generateLandingTime(String destination)
    {

        int[] destCoords = findAirportCoords(destination);

        int flightTime = flightTimes.get(destCoords[0]).get(destCoords[1]);

        return flightTime;

    }

    public static void generateFlightTimesAL(int[] originCoords, int[] mapSize)
    {

        for(int i = 0; i < mapSize[0]; i++)
        {

            flightTimes.add(new ArrayList<Integer>());

        }
        for(int row = 0; row < mapSize[0]; row++)
        {

            for (int col = 0; col < mapSize[1]; col++)
            {

                 int flightDistanceLat = Math.abs((row-originCoords[0]));
                 int flightDistanceLong = Math.abs((col-originCoords[1]));

                 int flightTime = (int) Math.round(Math.sqrt(Math.pow(((30) * flightDistanceLat),2)+(Math.pow(((30) * flightDistanceLong),2))));

                 if(flightTime == 0)
                     flightTime = 30;

                 flightTimes.get(row).add(flightTime);

            }

        }

    }

}//end Airport class
