package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Plane
{

    Random random = new Random();

    int passengerCapacity;

    ArrayList<Passenger> passengers = new ArrayList<>();

    String destination;

    Airline airline = new Airline();

    public Plane(int capacity)
    {

        this.passengerCapacity = capacity;

    }

    public Plane()
    {



    }

    public void fillPlane(int flightNumber)
    {

        for(int i = 0; i < passengerCapacity; i++) {

            ArrayList<Integer> passengerBags = new ArrayList<>();

            int jCounter = random.nextInt(3) + 1;

            for (int j = 0; j < jCounter; j++)
            {

                int bagWeight = 0;

                bagWeight = random.nextInt(30)+20;

                passengerBags.add(bagWeight);

            }

            Passenger passenger = new Passenger(flightNumber,flightNumber + "_" + (i+1), passengerBags);

            passengers.add(passenger);

        }

    }

}
