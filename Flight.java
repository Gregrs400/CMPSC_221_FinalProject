package FinalProject;

import java.util.*;

public class Flight
{//begin Flight class

    //integer variables which store different times
    private int departureTime;
    private int departureTimeHour;
    private int departureTimeMin;

    private int landingTime;
    private int landingTimeHour;
    private int landingTimeMin;

    private int flightTime;
    private int flightTimeHour;
    private int flightTimeMin;

    //int variable number representing the flight number
    private int number;

    //String object destination representing the destination of the flight
    private String destination;

    //random object being used to determine the flight status of a flight
        //planning to remove after time is implemented

    Random random = new Random();

    //Plane object being used for Flight parameterized constructor

    private Plane plane;

    Gate gate = new Gate(50);

    flightStatus fs;

    private ArrayList<Passenger> paxWithTickets = new ArrayList<>();

    public int getDepartureTimeHour() {return departureTimeMin;}

    public void setDepartureTimeHour(int departureTimeHour) {
        this.departureTimeHour = departureTimeHour;
    }

    public int getDepartureTimeMin() {return departureTimeHour;}

    public void setDepartureTimeMin(int departureTimeMin) {
        this.departureTimeMin = departureTimeMin;
    }

    public int getLandingTimeHour() {
        return landingTimeHour;
    }

    public void setLandingTimeHour(int landingTimeHour) {
        this.landingTimeHour = landingTimeHour;
    }

    public int getLandingTimeMin() {
        return landingTimeMin;
    }

    public void setLandingTimeMin(int landingTimeMin) {
        this.landingTimeMin = landingTimeMin;
    }

    public int getFlightTimeHour() {
        return flightTimeHour;
    }

    public void setFlightTimeHour(int flightTimeHour) {
        this.flightTimeHour = flightTimeHour;
    }

    public int getFlightTimeMin() {
        return flightTimeMin;
    }

    public void setFlightTimeMin(int flightTimeMin) {
        this.flightTimeMin = flightTimeMin;
    }

    public int getFlightTime() {return flightTime; };

    public void setFlightTime(int flightTime) {this.flightTime = flightTime;}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Gate getGate() {return gate; }

    public int getDepartureTime() {return departureTime;}
    public void setDepartureTime(int departureTime) {this.departureTime = departureTime;}

    public int getLandingTime() {return landingTime;}

    public void setLandingTime(int landingTime) {this.landingTime = landingTime;}

    public ArrayList<Passenger> getPaxWithTickets() {
        return paxWithTickets;
    }

    //Flight parameterized constructor, assigning a plane, a destination, a number, and the departure time of each flight
    public Flight(Plane plane, String destination, int number, int departureTimeHour, int departureTimeMin, int departureTime)
    {//begin Flight parameterized constructor

        setPlane(plane);
        setDestination(destination);
        setNumber(number);
        setDepartureTimeHour(departureTimeHour);
        setDepartureTimeMin(departureTimeMin);
        setDepartureTime(departureTime);
        fs = flightStatus.ONTIME;

    }//end Flight parameterized constructor

    public boolean isSoldOut()
    {

        if(paxWithTickets.size() < plane.getPassengerCapacity())
        {

            return false;

        }
        else
        {

            return true;

        }

    }

    public Flight()
    {



    }


    //flight status enum to assign a flight status depending on the events of the flight
    enum flightStatus
    {//begin flightStatus enum

        EARLY,
        ONTIME,
        DELAYED,
        CANCELLED;

    }//end flightStatus enum



    public int getSeatsTakenOnFlight()
    {

        return paxWithTickets.size();

    }

    public void printFlight()
    {

        System.out.println("Flight Number: " +  number);
        System.out.println("Destination: " + destination);



        printTime("Departure", departureTimeHour, departureTimeMin);

        printTime("Landing", landingTimeHour, landingTimeMin);

        System.out.println("Flight Status: " + fs);

        System.out.println();

        }
    
    public void printTime(String status, int hour, int min)
    {

        if(hour < 12) {
            if (hour == 0) {
                if (min < 10) {
                    System.out.println(status + " time: " + (hour + 12)
                            + ":" + 0 + min + " AM");
                } else {
                    System.out.println(status + " time: " + (hour + 12)
                            + ":" + min + " AM");
                }
            } else if (min < 10) {
                System.out.println(status + " time: " + hour
                        + ":" + 0 + min + " AM");
            } else {
                System.out.println(status + " time: " + hour
                        + ":" + min + " AM");
            }
        }
        else
        {
                if(hour == 12)
                {
                    System.out.println(status + " time: " + hour
                            + ":" + min + " PM");
                }
                else
                if (min < 10)
                {
                    System.out.println(status + " time: " + (hour - 12)
                            + ":" + 0 + min + " PM");
                }
                else
                {
                    System.out.println(status + " time: " + (hour - 12)
                            + ":" + min + " PM");
                }

            }    
        
    }

}//end flight
