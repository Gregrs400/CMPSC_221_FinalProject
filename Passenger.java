package FinalProject;

import java.util.Random;

public class Passenger extends Person
{

    int numOfBags;

    double bagWeight;

    Random random = new Random();

    int num = 0;

    public Passenger(String name, int numOfBags, double bagWeight)
    {


        this.name = name;
        this.numOfBags = numOfBags;
        this.bagWeight = bagWeight;

    }

    public Passenger()
    {


    }

}
