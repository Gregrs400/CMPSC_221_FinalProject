package FinalProject;

import java.util.ArrayList;

public class Passenger extends Person
{//begin Passenger class

    //Integer ArrayList storing the weights of passengers' bags

    ArrayList<Integer> bags = new ArrayList<>();

    //placeholder int variable for Flight Numbers before they are passed in during passenger construction

    int flightNumber = 0;

    //Passenger parameterized constructor, assigning each passenger a flight number, an id, and 1-3 bags inclusive

    public Passenger(int flightNumber, String id, ArrayList<Integer> bags)
    {//begin Passenger parameterized constructor

        this.flightNumber = flightNumber;
        this.id = id;
        this.bags = bags;

    }//end Passenger parameterized constructor

}//end Passenger class
