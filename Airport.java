package FinalProject;

public class Airport
{

    public static void main(String[] args) {

        Passenger pax1 = new Passenger();

        pax1.name = "name";

        Flight flight1 = new Flight();

        System.out.println(flight1.generateStatus());

        Plane plane1 = new Plane();

        plane1.fillPlane();

    }

}
