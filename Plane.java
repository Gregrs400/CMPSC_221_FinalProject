package FinalProject;

import java.util.ArrayList;

public class Plane
{

    int passengerCapacity;

    ArrayList<Passenger> passengers = new ArrayList<>();

    public void fillPlane()
    {

        for(int i = 0; i < 10; i++)
        {

            Passenger passenger = new Passenger("name" + (i+1), 2, 40);

            passengers.add(passenger);

        }


        Passenger passengerPrinter = new Passenger();

        for(int i = 0; i < passengers.size(); i++)
        {

            passengerPrinter = passengers.get(i);

            System.out.println(passengerPrinter.name);
            System.out.println(passengerPrinter.numOfBags);
            System.out.println(passengerPrinter.bagWeight);

        }
    }

}
