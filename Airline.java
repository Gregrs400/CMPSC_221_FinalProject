package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Airline
{//begin Airline class

    //String ArrayList of destinations offered by an airline from this airport

    private ArrayList<String> destinations = new ArrayList<>();

    //Integer ArrayList of Flight Numbers of flights created by the airline

    private ArrayList<Integer> flightNumbers = new ArrayList<>();

    //Flight object ArrayList storing the flights created by the airline

    private ArrayList<Flight> flights = new ArrayList<>();

    //Plane object ArrayList storing the planes in an airline's fleet

    private ArrayList<Plane> airlineFleet = new ArrayList<>();

    //Airline parameterized constructor


    public ArrayList<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList<String> destinations) {
        this.destinations = destinations;
    }

    public ArrayList<Integer> getFlightNumbers() {
        return flightNumbers;
    }

    public void setFlightNumbers(ArrayList<Integer> flightNumbers) {
        this.flightNumbers = flightNumbers;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<Plane> getAirlineFleet() {
        return airlineFleet;
    }

    public void setAirlineFleet(ArrayList<Plane> airlineFleet) {
        this.airlineFleet = airlineFleet;
    }

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

            if(flights.get(i).getDestination() == destination)
            {//begin if statement

                System.out.println(flights.get(i).getNumber());

            }//end if statement

        }//end for loop

    }//end printFlightNumbers

    public void printAllFlights(String destination)
    {//begin printAllFlights

        for(int i = 0; i < flights.size(); i++)
        {//begin for loop

            if(flights.get(i).getDestination() == destination)
            {//begin if statement

                printFlight(i);

            }//end if statement

        }//end for loop

    }//end printAllFlights

    //printFlight method to print all info about particular flight in flightsArrayList, as determined by int in call
    public void printFlight(int element)
    {

        System.out.println("Flight Number: " + flights.get(element).getNumber());
        System.out.println("Destination: " + flights.get(element).getDestination());

        if(flights.get(element).getDepartureTimeHour() < 12)
            if(flights.get(element).getDepartureTimeHour() == 0) {
                if (flights.get(element).getDepartureTimeMin() <= 10)
                {
                    System.out.println("Flight " + (element + 1) + " departure time: " + (flights.get(element).getDepartureTimeHour() + 12)
                            + ":" + 0 + flights.get(element).getDepartureTimeMin() + " AM");
                }
                else
                {
                    System.out.println("Flight " + (element + 1) + " departure time: " + (flights.get(element).getDepartureTimeHour() + 12)
                            + ":" + flights.get(element).getDepartureTimeMin() + " AM");
                }
            }
            else
                if (flights.get(element).getDepartureTimeMin() <= 10)
                {
                    System.out.println("Flight " + (element + 1) + " departure time: " + flights.get(element).getDepartureTimeHour()
                            + ":" + 0 + flights.get(element).getDepartureTimeMin() + " AM");
                }
                else
                {
                System.out.println("Flight " + (element+1) + " departure time: " + flights.get(element).getDepartureTimeHour()
                        + ":" + flights.get(element).getDepartureTimeMin() + " AM");
                }
        else
        {
            if(flights.get(element).getDepartureTimeHour() == 12)
            {
                System.out.println("Flight " + (element + 1) + " departure time: " + flights.get(element).getDepartureTimeHour()
                        + ":" + flights.get(element).getDepartureTimeMin() + " PM");
            }
            else
                if (flights.get(element).getDepartureTimeMin() <= 10)
                {
                    System.out.println("Flight " + (element + 1) + " departure time: " + (flights.get(element).getDepartureTimeHour() - 12)
                            + ":" + 0 + flights.get(element).getDepartureTimeMin() + " PM");
                }
                else
                {
                    System.out.println("Flight " + (element + 1) + " departure time: " + (flights.get(element).getDepartureTimeHour() - 12)
                            + ":" + flights.get(element).getDepartureTimeMin() + " PM");
                }

        }

        System.out.println();
    }


}
