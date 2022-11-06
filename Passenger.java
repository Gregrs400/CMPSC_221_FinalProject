package FinalProject;

import java.util.ArrayList;

public class Passenger extends Person
{//begin Passenger class

    ArrayList<Integer> bags = new ArrayList<>();

    int flightNumber = 0;

    public Passenger(int flightNumber, String name, ArrayList<Integer> bags)
    {//begin Passenger parameterized constructor

        this.flightNumber = flightNumber;
        this.name = name;
        this.bags = bags;

    }//end Passenger parameterized constructor

    public Passenger()
    {//begin Passenger default no args constructor


    }//end Passenger default no args constructor

}//end Passenger class
