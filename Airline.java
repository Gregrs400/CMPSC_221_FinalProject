package FinalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    public void generateFlight (Plane plane, int departHour, int departMin)
    {//begin generateFlight

        Random random = new Random();

        String destination;

        int flightNumber = 0;

        //do-while loop to ensure each flight number is unique

        do
        {//begin do-while loop

            flightNumber = random.nextInt(999)+1;

        }while(flightNumbers.contains(flightNumber)); //end do-while loop

        flightNumbers.add(flightNumber);

        destination = destinations.get(random.nextInt(destinations.size()));

        Flight flight1 = new Flight(plane, destination, flightNumber, departHour, departMin);

        flights.add(flight1);

    }

    //printFlightNumbers method to print any flight numbers in the flights ArrayList that match the destination in the call

    public void printFlightNumbers(String destination)
    {//begin printFlightNumbers

        for(int i = 0; i < flights.size(); i++)
        {//begin for loop

            if(flights.get(i).destination == destination)
            {//begin if statement

                System.out.println(flights.get(i).number);

            }//end if statement

        }//end for loop

    }//end printFlightNumbers

    public void printAllFlights(String destination)
    {//begin printAllFlights

        for(int i = 0; i < flights.size(); i++)
        {//begin for loop

            if(flights.get(i).destination == destination)
            {//begin if statement

                printFlight(i);

            }//end if statement

        }//end for loop

    }//end printAllFlights

    //printFlight method to print all info about particular flight in flightsArrayList, as determined by int in call
    public void printFlight(int element)
    {

        System.out.println("Flight Number: " + flights.get(element).number);
        System.out.println("Destination: " + flights.get(element).destination);

        if(flights.get(element).departureTimeHour < 12)
            if(flights.get(element).departureTimeHour == 0) {
                if (flights.get(element).departureTimeMin <= 10)
                {
                    System.out.println("Flight " + (element + 1) + " departure time: " + (flights.get(element).departureTimeHour + 12)
                            + ":" + 0 + flights.get(element).departureTimeMin + " AM");
                }
                else
                {
                    System.out.println("Flight " + (element + 1) + " departure time: " + (flights.get(element).departureTimeHour + 12)
                            + ":" + flights.get(element).departureTimeMin + " AM");
                }
            }
            else
            {
                System.out.println("Flight " + (element+1) + " departure time: " + flights.get(element).departureTimeHour
                        + ":" + flights.get(element).departureTimeMin + " AM");
            }
        else
        {
            if(flights.get(element).departureTimeHour == 12)
            {
                System.out.println("Flight " + (element + 1) + " departure time: " + flights.get(element).departureTimeHour
                        + ":" + flights.get(element).departureTimeMin + " PM");
            }
            else
            {
                System.out.println("Flight " + (element + 1) + " departure time: " + (flights.get(element).departureTimeHour - 12)
                        + ":" + flights.get(element).departureTimeMin + " PM");
            }
        }

        System.out.println();
    }


}
