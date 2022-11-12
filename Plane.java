package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Plane
{//begin Plane class

    //creating Random object for determining passenger's number of bags and each bag's weight
    private Random random = new Random();

    //declaring int variable to store how many passengers can board plane, defining characteristic of each plane
    private int passengerCapacity;

    //declaring Passenger type ArrayList for storing the Passenger objects on the plane
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    //Plane parameterized constructor for use by airlines
    public Plane(int capacity, ArrayList<Passenger> passengers)
    {//begin Plane parameterized constructor

        this.passengerCapacity = capacity;
        setPassengers(passengers);

    }//end Plane parameterized constructor

    public void addPaxtoPlane(Passenger passenger)
    {

        passengers.add(passenger);

    }

    //fillPlane method which fills plane to passengerCapacity with passengers
        //may be removed after time is implemented

//    public void fillPlane(int flightNumber)
//    {//begin fillPlane
//
//    //outer loop, "i" representing the element of the passenger ArrayList, as well as the id of the passenger
//
//        for(int i = 0; i < passengerCapacity; i++)
//        {//begin outer for loop
//
//            ArrayList<Integer> passengerBags = new ArrayList<>();
//
//            //assigning random int between 1 and 3 inclusive, determining the amount of times the inner loop will run, and the number of bags that will be created
//
//            int jCounter = random.nextInt(3) + 1;
//
//            //inner loop, "j" representing the creation of a passenger's bag, and the element of that bag in the bags ArrayList
//            //bagWeight represents the weight of a passenger's bag in pounds, 50 being the upper limit. All bags are between 20 and 50 pounds inclusive at the moment
//
//            for (int j = 0; j < jCounter; j++)
//            {//begin inner for loop
//
//                int bagWeight = 0;
//
//                bagWeight = random.nextInt(30)+20;
//
//                passengerBags.add(bagWeight);
//
//            }//end inner for loop
//
//            //creating the Passenger objects and adding them to the passengers ArrayList
//
//            Passenger passenger = new Passenger(flightNumber, flightNumber + "_" + (i+1), passengerBags);
//
//            passengers.add(passenger);
//
//        }//end outer for loop
//
//    }//end fillPlane

}//end Plane class
