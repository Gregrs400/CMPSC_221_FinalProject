package FinalProject;

import java.util.ArrayList;

public class Gate
{

    private int seats;

    Plane plane;

    public void setSeats(int seats)
    {

        this.seats = seats;

    }

    public Gate(int numOfSeats)
    {//begin Gate parameterized constructor

        setSeats(numOfSeats);

    }//end Gate parameterized constructor

    ArrayList<Passenger> paxAtGate = new ArrayList<>();

    public void addPaxToGate(Passenger passenger)
    {

        paxAtGate.add(passenger);

    }

}
