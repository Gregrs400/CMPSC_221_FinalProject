package FinalProject;

import java.util.ArrayList;
import java.util.Random;

public class Passenger extends Person
{

    ArrayList<Integer> bags = new ArrayList<>();

    Random random = new Random();

    int num = 0;

    public Passenger(String name, ArrayList<Integer> bags)
    {


        this.name = name;
        this.bags = bags;

    }

    public Passenger()
    {


    }

}
