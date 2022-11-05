package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Plane
{

    int passengerCapacity;

    Random random = new Random();

    ArrayList<Passenger> passengers = new ArrayList<>();

    String destination;

    int flightNumber = 0;

    Airline airLine = new Airline();

    Flight flight = new Flight();

    public Plane(Airline airline, Flight flight)
    {

        this.airLine = airline;
        this.flight = flight;

    }

    public void fillPlane()
    {

        for(int i = 0; i < 10; i++) {

            ArrayList<Integer> passengerBags = new ArrayList<>();

            int jCounter = random.nextInt(3) + 1;

            for (int j = 0; j < jCounter; j++)
            {

                int bagWeight = 0;

                bagWeight = random.nextInt(30)+20;

                passengerBags.add(bagWeight);

            }

            Passenger passenger = new Passenger("name" + (i+1), passengerBags);

            passengers.add(passenger);

        }

        for(int k = 0; k < passengers.size(); k++)
        {

            System.out.println("\n" + passengers.get(k).name);

            for(int l = 0; l < passengers.get(k).bags.size(); l++)
            {

                System.out.println(passengers.get(k).bags.get(l));

            }

        }
    }

}
