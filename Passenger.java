package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Passenger extends Person
{

    ArrayList<Integer> bags = new ArrayList<>();

    Airline airline = new Airline();

    Random random = new Random();

    int num = 0;

    int flightNumber = 0;

    public Passenger(int flightNumber, String name, ArrayList<Integer> bags)
    {

        this.flightNumber = flightNumber;
        this.name = name;
        this.bags = bags;

    }

    public Passenger()
    {


    }

}
