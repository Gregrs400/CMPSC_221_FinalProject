package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Plane
{

    int passengerCapacity;

    Random random = new Random();

    ArrayList<Passenger> passengers = new ArrayList<>();

    ArrayList<Integer> passengerBags = new ArrayList<>();
    public void fillPlane()
    {

        for(int i = 0; i < 10; i++) {

            int jCounter = random.nextInt(3) + 1;

            System.out.println(jCounter);

            for (int j = 0; j < jCounter; j++)
            {

                int bagWeight = 0;

                bagWeight = random.nextInt(30)+20;

                System.out.println(bagWeight);

                passengerBags.add(bagWeight);

            }

            Passenger passenger = new Passenger("name" + (i+1), passengerBags);

            passengers.add(passenger);

            passengerBags.clear();

        }


        Passenger passengerPrinter = new Passenger();

        System.out.println("bags size: " + passengerPrinter.bags.size());

        for(int i = 0; i < passengers.size(); i++)
        {

            passengerPrinter = passengers.get(i);

            System.out.println(passengerPrinter.name);

            for(int j = 0; j < passengerPrinter.bags.size(); j++)
            {

                System.out.println(passengerPrinter.bags.get(j));

            }

        }
    }

}
