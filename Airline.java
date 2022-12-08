package FinalProject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Airline {
    public JList returnFLights = new JList();

    //ARRAYLIST OF AVAILABLE DESTINATIONS FROM SPECIFIC AIRPORT
    private ArrayList<String> destinations = new ArrayList<>();
    public void setDestinations(ArrayList<String> destinations) {this.destinations = destinations;}

    //ARRAYLIST FOR FLIGHT NUMBERS
    private ArrayList<Integer> flightNumbers = new ArrayList<>();
    public void setFlightNumbers(ArrayList<Integer> flightNumbers) {this.flightNumbers = flightNumbers;}

    //ARRAYLIST FOR FLIGHTS
    private ArrayList<Flight> flights = new ArrayList<>();
    public ArrayList<Flight> getFlights() {return flights;}

    //ARRAYLIST FOR PLANE MODELS AND METHOD TO ADD PLANES
    private ArrayList<Plane> airlineFleet = new ArrayList<>();
    public ArrayList<Plane> getAirlineFleet() {return airlineFleet;}

    public void addPlane(Plane plane){
        airlineFleet.add(plane);
    }

    //HASHMAP LINKING FLIGHT OBJ's TO FLIGHT NUMBERS
    private HashMap<Integer, Flight> flightNumToFlight = new HashMap<>();
    public HashMap<Integer, Flight> getFlightNumToFlight() {return flightNumToFlight;}


    //PARAMETERIZED CONSTRUCTOR METHOD
    public Airline(ArrayList<String> destinations, ArrayList<Integer> flightNumbers){
        setDestinations(destinations);
        setFlightNumbers(flightNumbers);
    }


    //generateFlight to create a flight for an airline, assigning each flight a plane, a destination, a flight number, and a departure time
    public Flight generateFlight(Plane plane, String origin, int departHour, int departMin, int departTime, Gate gate) {

        Random random = new Random();
        String destination;
        int flightNumber = 0;

        //do-while loop to ensure each flight number is unique
        do{
            flightNumber = random.nextInt(9999)+1;
        }while(flightNumbers.contains(flightNumber));

        flightNumbers.add(flightNumber);
        destination = destinations.get(random.nextInt(destinations.size()));
        Flight flight = new Flight(plane, destination, origin, flightNumber, departHour, departMin, departTime, gate);
        flights.add(flight);
        flightNumToFlight.put(flight.getNumber(), flight);

        return flight;
    }

    //printFlightNumbers method to print any flight numbers in the flights ArrayList that match the destination in the call
    public void printFlightNumbers(String destination) {

        for(int i = 0; i < flights.size(); i++) {

            if(flights.get(i).getDestination() == destination) {
                System.out.println(flights.get(i).getNumber());
            }
        }
    }

    public void printFlightsWithSameDest(String destination, String origin) {
        for(int i = 0; i < flights.size(); i++) {
            if(flights.get(i).getDestination() == destination) {
                flights.get(i).setOriginAirport(origin);
                flights.get(i).printFlight();

            }
        }
    }

    public String[] flightsWithSameDestForUi(String destination, String origin)
    {

        ArrayList<String> uiFlights = new ArrayList<>();

        for(int i = 0; i < flights.size(); i++) {
            if(flights.get(i).getDestination() == destination) {

                flights.get(i).setOriginAirport(origin);

                Flight currentFlight = flights.get(i);

                String flightForUI = String.valueOf(currentFlight.getNumber()) + " " +
                        currentFlight.returnTime("Departure", currentFlight.getDepartureTimeHour(), currentFlight.getDepartureTimeMin(), currentFlight.getDepartureTime())
                        + " " + currentFlight.returnTime("Landing", currentFlight.getLandingTimeHour(), currentFlight.getLandingTimeMin(), currentFlight.getLandingTime())
                        + " " + currentFlight.getGate().getName();

                uiFlights.add(flightForUI);
            }
        }

        return uiFlights.toArray(new String[uiFlights.size()]);

    }

    public void printAllFlights() {
        for(Flight flight : flights) {
            flight.printFlight();
        }
    }

    public int getPassengerTotal() {

        int passengerTotal = 0;

        for(Flight flight : flights) {
            Plane flightPlane = flight.getPlane();
            passengerTotal += flightPlane.getPassengers().size();
        }

        return passengerTotal;
    }

    public Passenger getPassengerOnFlight(int flightElement, int passengerElement) {
        return getFlights().get(flightElement).getPaxWithTickets().get(passengerElement);
    }

    public void printPaxWithSameDest(String destination) {
        for(Flight flight : flights) {
            if(flight.getDestination().equals(destination)) {
                for(Passenger passenger : flight.getPaxWithTickets()) {
                    passenger.printPassenger();
                }
            }
        }
    }

    public Flight paxFlightFromNum(Passenger passenger) {
        Flight flight = getFlightNumToFlight().get(passenger.getFlightNumber());
        return flight;
    }

    public void removeFromDestinations(String destination) {
        destinations.remove(destination);

    }
}
