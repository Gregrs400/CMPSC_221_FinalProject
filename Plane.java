package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Plane
{//begin Plane class

    Random random = new Random();

    int passengerCapacity;

    ArrayList<Passenger> passengers = new ArrayList<>();

    Airline airline = new Airline();

    public Plane(int capacity)
    {//begin Plane parameterized constructor

        this.passengerCapacity = capacity;

    }//end Plane parameterized constructor


    public void fillPlane(int flightNumber)
    {//begin fillPlane

        for(int i = 0; i < passengerCapacity; i++)
        {//begin outer for loop

            ArrayList<Integer> passengerBags = new ArrayList<>();

            int jCounter = random.nextInt(3) + 1;

            for (int j = 0; j < jCounter; j++)
            {//begin inner for loop

                int bagWeight = 0;

                bagWeight = random.nextInt(30)+20;

                passengerBags.add(bagWeight);

            }//end inner for loop

            Passenger passenger = new Passenger(flightNumber,flightNumber + "_" + (i+1), passengerBags);

            passengers.add(passenger);

        }//end outer for loop

    }//end fillPlane

}//end Plane class
