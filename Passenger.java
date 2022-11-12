package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Passenger extends Person
{//begin Passenger class

    Random random = new Random();

    //Integer ArrayList storing the weights of passengers' bags

    private ArrayList<Integer> bags = new ArrayList<>();

    //placeholder int variable for Flight Numbers before they are passed in during passenger construction

    private int flightNumber = 0;

    private String destination;

    public ArrayList<Integer> getBags() {
        return bags;
    }

    public void setBags(ArrayList<Integer> bags) {
        this.bags = bags;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    //Passenger parameterized constructor, assigning each passenger a flight number, an id, and 1-3 bags inclusive

    public Passenger(int flightNumber, String destination, String id, ArrayList<Integer> bags)
    {//begin Passenger parameterized constructor

        this.flightNumber = flightNumber;
        this.destination = destination;
        setId(id);
        this.bags = getPassengerBags();

    }//end Passenger parameterized constructor

    public Passenger()
    {//begin Passenger default no args constructor



    }//end Passenger default no args constructor

    public ArrayList<Integer> getPassengerBags()
    {//begin getPassengerBags

        ArrayList<Integer> passengerBags = new ArrayList<>();

        //assigning random int between 1 and 3 inclusive, determining the amount of times the inner loop will run, and the number of bags that will be created

        int jCounter = random.nextInt(3) + 1;

        //inner loop, "j" representing the creation of a passenger's bag, and the element of that bag in the bags ArrayList
        //bagWeight represents the weight of a passenger's bag in pounds, 50 being the upper limit. All bags are between 20 and 50 pounds inclusive at the moment

        for (int j = 0; j < jCounter; j++)
        {//begin inner for loop

            int bagWeight = 0;

            bagWeight = random.nextInt(30)+20;

            passengerBags.add(bagWeight);

        }//end inner for loop

        return passengerBags;

    }//end getPassengerBags

    public void printPassenger(Passenger passenger)
    {

        System.out.println("Passenger Flight Number: " + passenger.getFlightNumber());
        System.out.println("Passenger ID: " + passenger.getId());
        System.out.println("Passenger destination: " + passenger.getDestination());

        for(int i = 0; i < passenger.getBags().size(); i++)
        {

            System.out.println("Bag " + (i+1) + " Weight: " + passenger.getBags().get(i));

        }

    }

}//end Passenger class
