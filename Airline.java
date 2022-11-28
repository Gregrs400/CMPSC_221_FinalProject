package FinalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Airline
{//begin Airline class

    //String ArrayList of destinations offered by an airline from this airport

    private ArrayList<String> destinations = new ArrayList<>();

    //Integer ArrayList of Flight Numbers of flights created by the airline

    private ArrayList<Integer> flightNumbers = new ArrayList<>();

    //Flight object ArrayList storing the flights created by the airline

    private ArrayList<Flight> flights = new ArrayList<>();

    //Plane object ArrayList storing the different planes in an airline's fleet

    private ArrayList<Plane> airlineFleet = new ArrayList<>();

    //Plane object ArrayList storing every plane utilized by an airline

    private ArrayList<Plane> rollingStock = new ArrayList<>();

    private HashMap<Integer, Flight> flightNumToFlight = new HashMap<>();

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

    public ArrayList<Plane> getRollingStock() {
        return rollingStock;
    }

    public void setRollingStock(ArrayList<Plane> rollingStock) {
        this.rollingStock = rollingStock;
    }

    public HashMap<Integer, Flight> getFlightNumToFlight() {
        return flightNumToFlight;
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

    public Flight generateFlight (Plane plane, String origin, int departHour, int departMin, int departTime, Gate gate)
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

        Flight flight = new Flight(plane, destination, origin, flightNumber, departHour, departMin, departTime, gate);

        flights.add(flight);

        flightNumToFlight.put(flight.getNumber(), flight);

        return flight;

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

                flights.get(i).printFlight();

            }//end if statement

        }//end for loop

    }//end printAllFlights



    public Passenger getPassengerOnFlight(int flightElement, int passengerElement)
    {

        return getFlights().get(flightElement).getPaxWithTickets().get(passengerElement);

    }

    public void printPaxWithSameDest(String destination){
        Passenger passenger;

        for(int i = 0; i < flights.size(); i++){
            if(flights.get(i).getDestination().equals(destination)){
                for(int j = 0; j < flights.get(i).getSeatsTakenOnFlight(); j++){
                    passenger = getPassengerOnFlight(i,j);
                    passenger.printPassenger();
                    System.out.println();
                }
            }
        }
    }

    public Flight paxFlightFromNum(Passenger passenger)
    {
        Flight flight = getFlightNumToFlight().get(passenger.getFlightNumber());

        return flight;
    }

    public void removeFromDestinations(String destination) {

        destinations.remove(destination);

    }

}//end Airline class
