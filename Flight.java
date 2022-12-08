package FinalProject;
import javax.swing.*;
import java.util.*;

public class Flight {
    //INSTANTIATING OTHER CLASSES
    private Plane plane;
    private Gate gate;
    public JList flights = new JList();


    //FLIGHT INFO VARIABLES
    private int number; //flightNumber
    private String destination;
    private String originAirport;

    private flightStatus fs;
    enum flightStatus {
        EARLY,
        ONTIME,
        DELAYED,
        CANCELLED;
    }


    //TIME VARIABLES
    private int departureTime;
    private int departureTimeHour;
    private int departureTimeMin;
    private int landingTime;
    private int landingTimeHour;
    private int landingTimeMin;
    private int flightTime;


    //GETTER & SETTERS
    //DEPARTURE TIME METHODS
    public int getDepartureTime() {return departureTime;}
    public void setDepartureTime(int departureTime) {this.departureTime = departureTime;}

    public int getDepartureTimeHour() {return departureTimeMin;}
    public void setDepartureTimeHour(int departureTimeHour) {
        this.departureTimeHour = departureTimeHour;
    }
    public void setDepartureTimeMin(int departureTimeMin) {this.departureTimeMin = departureTimeMin;}

    //LANDING TIME METHODS
    public void setLandingTime(int landingTime) {this.landingTime = landingTime;}
    public void setLandingTimeHour(int landingTimeHour) {this.landingTimeHour = landingTimeHour;}
    public void setLandingTimeMin(int landingTimeMin) {this.landingTimeMin = landingTimeMin;}

    //IN-FLIGHT TIME METHOD
    public void setFlightTime(int flightTime) {this.flightTime = flightTime;}

    //FLIGHT NUMBER METHODS
    public int getNumber() {return number;}
    public void setNumber(int number) {this.number = number;}

    //DESTINATION METHODS
    public String getDestination() {return destination;}
    public void setDestination(String destination) {this.destination = destination;}
    public void setOriginAirport(String originAirport) {this.originAirport = originAirport;}

    //PLANE METHODS
    public Plane getPlane() {return plane;}
    public void setPlane(Plane plane) {this.plane = plane;}

    //GATE METHODS
    public Gate getGate() {return gate;}
    public void setGate(Gate gate) {
        this.gate = gate;
        gate.gs = Gate.gateStatus.OCCUPIED;
    }


    private ArrayList<Passenger> paxWithTickets = new ArrayList<>();
    public ArrayList<Passenger> getPaxWithTickets() {return paxWithTickets;}


    //CONSTRUCTORS
    //PARAMETERIZED VARIANT: ASSIGNS PLANE, DESTINATION, FLIGHT NUMBER, DEPARTURE TIME
    public Flight(Plane plane, String destination, String originAirport, int number, int departureTimeHour, int departureTimeMin, int departureTime, Gate gate) {
        setPlane(plane);
        setDestination(destination);
        setOriginAirport(originAirport);
        setNumber(number);
        setDepartureTimeHour(departureTimeHour);
        setDepartureTimeMin(departureTimeMin);
        setDepartureTime(departureTime);
        setGate(gate);
        gate.addPlane(plane);
        fs = flightStatus.ONTIME;
    }

    //EMPTY VARIANT
    public Flight() {

    }


    //SEAT METHODS
    public boolean isSoldOut() {
        if(paxWithTickets.size() < plane.getPaxCapacity()) {
            return false;
        } else {
            return true;
        }
    }

    public int getSeatsTakenOnFlight() {return paxWithTickets.size();}


    //CUSTOM PRINT METHODS
    public void printFlight() {
        System.out.println("\nFlight Number: " + number);
        System.out.println("Origin: " + originAirport);
        System.out.println("Destination: " + destination);
        printTime("Departure", departureTimeHour, departureTimeMin, departureTime);
        printTime("Landing", landingTimeHour, landingTimeMin, landingTime);
        System.out.println("Gate: " + gate.getName());
        System.out.println("Flight Status: " + fs);
    }
    
    public void printTime(String status, int hour, int min, int time) {
        String suffix, zero;
        if (time > 719 && time < 1440)
            suffix = " PM";
        else
            suffix = " AM";

        if (min < 10)
            zero = "0";
        else
            zero = "";

        if (time < 60)
            hour = 12;

        if (hour > 12)
            hour -= 12;

        System.out.println(status + " time: " + hour + ":" + zero + min + suffix);
    }
}