package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Passenger extends Person
{//begin Passenger class

    Random random = new Random();

    //Integer ArrayList storing the weights of passengers' bags

    private ArrayList<Integer> bags = new ArrayList<>();

    //placeholder int variable for Flight Numbers before they are passed in during passenger construction

    private int flightNumber = 0;

    private String destination;

    private int curbToCheckIn, checkInToSecurity, securityToGate, gateToPlane, eatingTime;

    private boolean atGate = false;



    public ArrayList<Integer> getBags() {
        return bags;
    }

    public void setBags(ArrayList<Integer> bags) {
        this.bags = bags;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCurbToCheckIn() {return curbToCheckIn; }

    public int getCheckInToSecurity() {return checkInToSecurity; }

    public int getSecurityToGate() {return securityToGate; }

    public int getGateToPlane() {return gateToPlane; }

    public boolean isAtGate() {
        return atGate;
    }

    public void setAtGate(boolean atGate){this.atGate = atGate;}

    airportTravel at;

    Gate gate;


    //Passenger parameterized constructor, assigning each passenger a flight number, an id, and 1-3 bags inclusive

    public Passenger(int flightNumber, String destination, String id, Gate gate)
    {//begin Passenger parameterized constructor

        this.flightNumber = flightNumber;
        this.destination = destination;
        setId(id);
        bags = getPassengerBags();
        commuteThroughAirport();
        this.gate = gate;

        curbToCheckIn = getCurbToCheckIn();
        checkInToSecurity = getCheckInToSecurity();
        securityToGate = getSecurityToGate();
        gateToPlane = getGateToPlane();

        at = airportTravel.DROPPED_OFF;


    }//end Passenger parameterized constructor

    public Passenger()
    {//begin Passenger default no args constructor



    }//end Passenger default no args constructor

    enum airportTravel
    {

        DROPPED_OFF,
        CHECKING_IN,
        CHECKED_IN,
        AT_SECURITY,
        THROUGH_SECURITY,
        WALKING_TO_GATE,
        AT_GATE,
        EATING,
        BOARDING_PLANE

    }
    public ArrayList<Integer> getPassengerBags()
    {//begin getPassengerBags

        ArrayList<Integer> passengerBags = new ArrayList<>();

        //assigning random int between 1 and 3 inclusive, determining the amount of times the inner loop will run, and the number of bags that will be created

        int jCounter = random.nextInt(3) + 1;

        //inner loop, "j" representing the creation of a passenger's bag, and the element of that bag in the bags ArrayList
        //bagWeight represents the weight of a passenger's bag in pounds, 50 being the upper limit. All bags are between 20 and 50 pounds inclusive at the moment

        for (int j = 0; j < jCounter; j++)
        {//begin inner for loop

            int bagWeight;

            bagWeight = random.nextInt(30)+20;

            passengerBags.add(bagWeight);

        }//end inner for loop

        return passengerBags;

    }//end getPassengerBags

    public void printPassenger()
    {

        System.out.println("\nPassenger Flight Number: " + flightNumber);

        System.out.println("Passenger ID: " + getId());

        System.out.println("Passenger destination: " + destination);

        for(int i = 0; i < bags.size(); i++)
        {

            System.out.println("Bag " + (i+1) + " Weight: " + bags.get(i));

        }

    }

    public void commuteThroughAirport()
    {

        curbToCheckIn = random.nextInt(11)+5;
        checkInToSecurity = random.nextInt(6)+5;
        securityToGate = random.nextInt(31)+15;
        gateToPlane = random.nextInt(11)+5;

    }

    public void movePassenger()
    {

        if(at.equals(airportTravel.DROPPED_OFF))
        {

            curbToCheckIn--;

            if(curbToCheckIn == 0)
            {

                at = airportTravel.CHECKED_IN;

            }

        }

        if(at.equals(airportTravel.CHECKED_IN))
        {

            checkInToSecurity--;

            if(checkInToSecurity == 0)
            {

                at = airportTravel.THROUGH_SECURITY;

            }

        }

        if(at.equals(airportTravel.THROUGH_SECURITY))
        {

            securityToGate--;

        }

    }

    public void printPaxAirportStatus()
    {

        System.out.println(at);

    }

}//end Passenger class
