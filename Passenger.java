package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Passenger extends Person {
    Random rnJesus = new Random();

    //VARIABLES
    private int flightNumber = 0; //temp variable, replaced when pax are constructed
    private String destination;
    private int curbToCheckIn, checkInToSecurity, securityToGate, gateToPlane;
    private boolean atGate = false;
    private Gate gate;
    private Ticket ticket;

    airportTravel at;
    enum airportTravel {
        DROPPED_OFF,
        CHECKING_IN,
        CHECKED_IN,
        AT_SECURITY,
        THROUGH_SECURITY,
        WALKING_TO_GATE,
        AT_GATE,
        BOARDING_PLANE
    }


    //GETTER & SETTER METHODS
    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getCurbToCheckIn() {
        return curbToCheckIn;
    }

    public int getCheckInToSecurity() {
        return checkInToSecurity;
    }

    public int getSecurityToGate() {
        return securityToGate;
    }

    public int getGateToPlane() {
        return gateToPlane;
    }

    public boolean isAtGate() {
        return atGate;
    }

    public void setAtGate(boolean atGate) {
        this.atGate = atGate;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    //CONSTRUCTORS
    //PARAMETERIZED VARIANT ASSIGNS: FLIGHT NUMBER, PAX ID, 1-3 BAGS
    public Passenger(int flightNumber, String destination, String id, Gate gate) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        setId(id);
        bags = generatePassengerBags();
        commuteThroughAirport();
        this.gate = gate;
        ticket = new Ticket();

        curbToCheckIn = getCurbToCheckIn();
        checkInToSecurity = getCheckInToSecurity();
        securityToGate = getSecurityToGate();
        gateToPlane = getGateToPlane();

        at = airportTravel.DROPPED_OFF;
    }

    //EMPTY VARIANT
    public Passenger() {

    }


    //BAG INFO & GENERATION
    private ArrayList<Integer> bags = new ArrayList<>(); //ARRAYLIST FOR BAG WEIGHT

    //GENERATION ALGORITHM
    public ArrayList<Integer> generatePassengerBags() {
        //DETERMINE LOOP COUNT RANDOMLY TO MAKE BAGS, 1-3 INCLUSIVE
        int numOfBags = rnJesus.nextInt(3) + 1;
        ArrayList<Integer> passengerBags = new ArrayList<>();

        //RANDOMLY MAKE BAGS WEIGH BETWEEN 20-50LBS INCLUSIVE
        for (int i = 0; i < numOfBags; i++) {
            int bagWeight;
            bagWeight = rnJesus.nextInt(31)+20;
            passengerBags.add(bagWeight);
        }
        return passengerBags;
    }

    public ArrayList<Integer> getBags() {return bags;}
    public void setBags(ArrayList<Integer> bags) {this.bags = bags;}


    //printPassenger to print information about a passenger
    public void printPassenger() {
        System.out.println("\nPassenger Flight Number: " + flightNumber);
        System.out.println("Passenger ID: " + getId());
        System.out.println("Ticket Number: " + ticket.ticketNum);
        System.out.println("Passenger destination: " + destination);

        for(int i = 0; i < bags.size(); i++) {//begin for loop to print all passenger's bag weights
            System.out.println("Bag " + (i+1) + " Weight: " + bags.get(i) + " pounds");
        }//end for loop to print all passenger's bag weights
    }

    /* commuteThroughAirport generates durations for each stage of
    a passenger getting from the curb to the gate of their airport */
    public void commuteThroughAirport() {
        curbToCheckIn = rnJesus.nextInt(11)+5;
        checkInToSecurity = rnJesus.nextInt(6)+5;
        securityToGate = rnJesus.nextInt(31)+15;
        gateToPlane = rnJesus.nextInt(11)+5;
    }

    /* movePassenger to get passengers to their gate through decrementing
    the above variables and switching enums when each field equals 0. The method
    is called for a passenger while they have not made it to their gate. */
    public void movePassenger(){
        //begin if passenger has been dropped off but not checked in
        if(at.equals(airportTravel.DROPPED_OFF)) {
            curbToCheckIn--;

            //begin if passenger has made it to check in
            if(curbToCheckIn == 0) {
                at = airportTravel.CHECKED_IN;
            }//end if passenger has made it to check in
        }//end if passenger has been dropped off but not checked in

        if(at.equals(airportTravel.CHECKED_IN)) {//begin if passenger has checked in but not been through security
            checkInToSecurity--;

            if(checkInToSecurity == 0) {//begin if passenger gets through security
                at = airportTravel.THROUGH_SECURITY;
            }//end if passenger gets through security
        }//end if passenger has checked in but not been through security

        if(at.equals(airportTravel.THROUGH_SECURITY)) {//begin if passenger is through security but not gotten to gate
            securityToGate--;
        }//end if passenger is through security but not gotten to gate
    }


    public void movePax(){

    }

    //prints the enum currently set to the Passenger object
    public void printPaxAirportStatus() {//begin printPaxAirportStatus
        System.out.println(at);
    }
}
