package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Plane {
    //INSTANTIATING OTHER CLASSES
    private Gate gate;
    private Airline airline;

    //VARIABLES
    private Random random = new Random(); //determines pax #bags and weight
    private int paxCapacity;
    private int seatsTaken;
    private int gateOccupationTime = 15;

    //these values are used in setFlightTime()
    private int taxiingToRunwayTime, takingOffTime, enRouteTime, descendingTime, landingTime, taxiingToGateTime;
    private Flight flight;

    planeStatus ps;
    enum planeStatus {
        AT_DEPART_GATE,
        READY_TO_TAXI,
        TAXIING,
        TAKING_OFF,
        EN_ROUTE,
        DESCENDING,
        LANDING,
        LANDED,
        TAXIING_TO_GATE,
        AT_GATE
    }

    //GETTER & SETTER METHODS
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getPaxCapacity() {
        return paxCapacity;
    }

    public void setPaxCapacity(int paxCapacity) {
        this.paxCapacity = paxCapacity;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }


    //PLANE CONSTRUCTOR METHODS
    public Plane(int capacity) {
        this.paxCapacity = capacity;
        setPassengers(passengers);
        ps = planeStatus.AT_DEPART_GATE;
    }

    public Plane() {

    } //empty constructor method


    //ARRAYLIST FOR PAX OBJ's ON PLANE
    private ArrayList<Passenger> passengers = new ArrayList<>();
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }


    //LONG SET METHODS
    public void setFlightTimes(int flightTime) {
        int ascentDescentTime;
        enRouteTime = flightTime;

        if (enRouteTime <= 60) {
            int taxiingTime = 1;
            ascentDescentTime = Math.round(enRouteTime / 6);

            taxiingToRunwayTime = taxiingTime;
            enRouteTime = enRouteTime - taxiingToRunwayTime;

            takingOffTime = ascentDescentTime;
            enRouteTime = enRouteTime - ascentDescentTime;

            descendingTime = ascentDescentTime;
            enRouteTime = enRouteTime - ascentDescentTime;

            landingTime = 3;
            descendingTime = descendingTime - landingTime;

            taxiingToGateTime = taxiingTime;
            enRouteTime = enRouteTime - taxiingToGateTime;
        }

        if (enRouteTime > 60) {
            int taxiingTime = 5;

            taxiingToRunwayTime = taxiingTime;
            enRouteTime = enRouteTime - taxiingToRunwayTime;

            ascentDescentTime = 15;

            takingOffTime = ascentDescentTime;
            enRouteTime = enRouteTime - ascentDescentTime;

            descendingTime = ascentDescentTime;
            enRouteTime = enRouteTime - ascentDescentTime;

            landingTime = 5;
            descendingTime = descendingTime - landingTime;

            taxiingToGateTime = taxiingTime;
            enRouteTime = enRouteTime - taxiingToGateTime;
        }
    }


    public void addPaxToPlane(Passenger passenger) {
        passengers.add(passenger);
    }

    public boolean isFull() {
        if (passengers.size() == paxCapacity) {
            return true;
        } else {
            return false;
        }
    }

    public void movePlane() {

        if (ps.equals(planeStatus.READY_TO_TAXI)) {
            ps = planeStatus.TAXIING;

            if (print == true) {
                System.out.println(ps);
            }
            taxiingToRunwayTime--;
        }

        if (gate.gs.equals(Gate.gateStatus.OCCUPIED)) {
            gateOccupationTime--;

            if (gateOccupationTime == 0) {
                gate.gs = Gate.gateStatus.EMPTY;
                gate.nextPlane();
            }
        }

        if (ps.equals(planeStatus.TAXIING)) {
            if (taxiingToRunwayTime == 0) {
                ps = planeStatus.TAKING_OFF;

                if (print == true) {
                    System.out.println(ps);
                }
                takingOffTime--;
            } else {
                taxiingToRunwayTime--;
            }
        }

        if (ps.equals(planeStatus.TAKING_OFF)) {
            if (takingOffTime == 0) {
                ps = planeStatus.EN_ROUTE;

                if (print == true)
                    System.out.println(ps);
                enRouteTime--;
            } else {
                takingOffTime--;
            }
        }

        if (ps.equals(planeStatus.EN_ROUTE)) {
            if (enRouteTime == 0) {
                ps = planeStatus.DESCENDING;

                if (print == true)
                    System.out.println(ps);
                descendingTime--;
            } else {
                enRouteTime--;
            }
        }

        if (ps.equals(planeStatus.DESCENDING)) {
            if (descendingTime == 0) {
                ps = planeStatus.LANDING;

                if (print == true)
                    System.out.println(ps);
                landingTime--;
            } else {
                descendingTime--;
            }
        }

        if (ps.equals(planeStatus.LANDING)) {
            if (landingTime == 0) {
                ps = planeStatus.LANDED;

                if (print == true)
                    System.out.println(ps);
                ps = planeStatus.TAXIING_TO_GATE;

                if (print == true)
                    System.out.println(ps);
                taxiingToGateTime--;
            } else {
                landingTime--;
            }
        }

        if (ps.equals(planeStatus.TAXIING_TO_GATE)) {
            if (taxiingToGateTime == 0) {
                ps = planeStatus.AT_GATE;

                if (print == true)
                    System.out.println(ps);

                if (print == true)
                    System.out.println("Flight " + flight.getNumber() + " made it to the gate.");
            } else {
                taxiingToGateTime--;
            }
        }
    }

    //SEAT METHODS, NEVER CALLED
    public int getSeatsTaken() {
        return seatsTaken;
    }
    public void setSeatsTaken(int seatsTaken) {
        this.seatsTaken = seatsTaken;
    }

    //PRINT STUFF, NEVER CALLED
    private boolean print = false;
    public void setPrint(boolean print) {
        this.print = print;
    }
}