package FinalProject;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;

public class Gate {
    //CALLING PLANE CLASS
    private Plane plane;

    //GATE VARIABLES
    private String name;
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    private int seats;
    public int getSeats(){return seats;}
    public void setSeats(int seats) {
        this.seats = seats;
    }

    gateStatus gs;
    enum gateStatus {
        EMPTY,
        OCCUPIED
    }

    //PARAMETERIZED GATE CONSTRUCTOR
    public Gate(int numOfSeats, String name) {//begin Gate parameterized constructor
        setSeats(numOfSeats);
        setName(name);
    }


    //GATE RELATED PLANE METHODS

    Deque<Plane> planeQueue = new LinkedList<>();

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void addPlane(Plane plane) {
        planeQueue.add(plane);
        if(gs.equals(gateStatus.EMPTY)) {
            setPlane(planeQueue.poll());
        }
    }

    public void nextPlane() {
        setPlane(planeQueue.poll());
    }

    public Plane getLastPlane(){
        return planeQueue.peekLast();
    }


    //GATE RELATED PASSENGER METHODS
    private ArrayList<Passenger> paxAtGate = new ArrayList<>();
    public ArrayList<Passenger> getPaxAtGate(){return paxAtGate;}
    public void addPaxToGate(Passenger passenger) {
        paxAtGate.add(passenger);
    }
}