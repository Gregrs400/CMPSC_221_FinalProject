package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class UI implements ActionListener {
    //INSTANTIATING AIRPORT
    public static Airport airport = new Airport();
    public static Passenger user = new Passenger();


    //UI VARIABLES
    private JLabel originLabel, destinationLabel, label, check;
    private JFrame mainFrame;
    private JPanel leftPanel, rightPanel;
    private JButton button;
    private JComboBox origin, destination;
    private JList listFlights;
    private JScrollPane scrollPane;
    private static String airportLocation;


    //CREATING AIRPORT OBJECT AND FLIGHTNUMBER/DESTINATIONS PARAMETERS
    public static ArrayList<Integer> flightNumbers = new ArrayList<>();
    public static ArrayList<String> alOneDestinations = new ArrayList<>(Arrays.asList(
            "Miami", "Charlotte", "Harrisburg", "Washington DC", "Baltimore", "Jacksonville",
            "Indianapolis", "Fort Lauderdale", "Savannah", "Roanoke", "Detroit", "Tampa", "Atlanta", "Orlando",
            "Los Angeles", "Denver", "San Francisco", "West Palm Beach", "San Jose", "Seattle", "Portland", "Dallas",
            "Austin", "Houston", "Daytona Beach", "Newark", "New York City", "Cincinnati", "Des Moines", "San Diego",
            "Minneapolis", "Phoenix", "Las Vegas", "Boston", "Philadelphia", "Nashville", "Chicago",
            "Key West", "New Orleans", "Birmingham", "Albuquerque", "Oklahoma City", "St. Louis", "Kansas City",
            "Milwaukee", "Boise", "San Antonio", "Jackson", "Memphis", "Huntsville", "Fort Meyers", "Louisville",
            "Green Bay"));

    public static Airline airLineOne = new Airline(alOneDestinations, flightNumbers);

    //ADDING DESTINATIONS FOR COMBO BOXES
    String destinations[] = {"Select Destination", "Miami", "Charlotte", "Harrisburg", "Washington DC", "Baltimore", "Jacksonville",
            "Indianapolis", "Fort Lauderdale", "Savannah", "Roanoke", "Detroit", "Tampa", "Atlanta", "Orlando",
            "Los Angeles", "Denver", "San Francisco", "West Palm Beach", "San Jose", "Seattle", "Portland", "Dallas",
            "Austin", "Houston", "Daytona Beach", "Newark", "New York City", "Cincinnati", "Des Moines", "San Diego",
            "Minneapolis", "Phoenix", "Las Vegas", "Boston", "Philadelphia", "Nashville", "Chicago",
            "Key West", "New Orleans", "Birmingham", "Albuquerque", "Oklahoma City", "St. Louis", "Kansas City",
            "Milwaukee", "Boise", "San Antonio", "Jackson", "Memphis", "Huntsville", "Fort Meyers", "Louisville",
            "Green Bay"};


    public UI(){
        //DEFINING VARIABLES
        //COMBO BOXES
        origin = new JComboBox(destinations);
        destination = new JComboBox(destinations);

        //LABELS
        check = new JLabel();
        check.setVisible(false);
        label = new JLabel("Please choose origin and destination airports");
        originLabel = new JLabel("Flight Origin");
        destinationLabel = new JLabel("Flight Destination");

        //CONTAINERS && BUTTON
        mainFrame = new JFrame("CMPSC221 Final Project");
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        button = new JButton("FIND FLIGHTS");


        //LEFT PANEL -- INPUT VALUES
        origin.setBounds(0, 50, 150, 25);
        originLabel.setBounds(30,30,150,25);
        destination.setBounds(200, 50, 150, 25);
        destinationLabel.setBounds(230,30,150,25);

        leftPanel.setBackground(Color.lightGray);
        leftPanel.setLayout(null);
        leftPanel.add(destination);
        leftPanel.add(destinationLabel);
        leftPanel.add(origin);
        leftPanel.add(originLabel);

        //BUTTON STUFF
        button.setBounds(100,100,150,25);
        button.addActionListener(this);
        leftPanel.add(button);


        //RIGHT PANEL -- RETURN VALUES
        label.setBounds(30,50,300,25);
        check.setBounds(10, 100,150,25);
        rightPanel.setLayout(null);
        rightPanel.add(label);
        rightPanel.add(check);
        rightPanel.setBackground(Color.lightGray);


        //ADD TO FRAME
        mainFrame.setLayout(new GridLayout(0,2));
        mainFrame.setSize(800,500);
        mainFrame.add(leftPanel);
        mainFrame.add(rightPanel);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Select Destination" == origin.getSelectedItem() && "Select Destination" == destination.getSelectedItem()){
            label.setText("Origin and Destination are still blank");
        } else if (destination.getSelectedItem() == "Select Destination") {
            label.setText("Please select a destination airport");
        } else if("Select Destination" == origin.getSelectedItem()){
            label.setText("Please select origin airport");
        } else if(origin.getSelectedItem() == destination.getSelectedItem()){
            label.setText("Cannot select same origin and destination");
        } else {
            label.setText("Showing flights to " + destination.getSelectedItem().toString() + " from " + origin.getSelectedItem().toString());
            airportLocation = origin.getSelectedItem().toString();
            user.setDestination(destination.getSelectedItem().toString());

            listFlights = new JList(airLineOne.flightsWithSameDestForUi(destination.getSelectedItem().toString(), origin.getSelectedItem().toString()));
            listFlights.setFixedCellHeight(30);
            listFlights.setFont(new Font("Dialog",Font.BOLD,12));
            scrollPane = new JScrollPane(listFlights);
            scrollPane.setBounds(0, 150, 350,250);
            rightPanel.add(scrollPane);
            scrollPane.setVisible(true);
            check.setVisible(true);
        }
    }

    public static void main(String[] args) {
        //GUI STUFF
        new UI();

        airport.numOfGates = 50;
        //determining location of airport and making flight times to other airports
        for(int i = 0; i < 9; i++) {
            airport.destMap.add(new ArrayList<>());
            for(int j = 0; j < 16; j++) {
                airport.destMap.get(i).add(new ArrayList<>());
            }
        }

        for(int i = 0; i < 2880; i++) {
            airport.movingPlanes.add(new ArrayList<>());
        }

        airport.fillDestMap(airport.destMap);
        //String airportLocation = "";

        int[] originCoords = airport.findAirportCoords(UI.airportLocation);
        airLineOne.removeFromDestinations(airportLocation);

        int[] mapSize = {airport.destMap.size(), airport.destMap.get(0).size()};
        airport.generateFlightTimesAL(originCoords, mapSize);

        //creating planes
        Plane plane1 = new Plane(50);
        Plane plane2 = new Plane(100);

        //adding plane1/plane2 to airlineOne's fleet
        airLineOne.addPlane(plane1);
        airLineOne.addPlane(plane2);

        ArrayList<Passenger> paxInAirport = new ArrayList<>();
        //paxInAirport.add(user);
        airport.newDay(airLineOne, airportLocation, paxInAirport);

        user.printPassenger();

//        Flight flight = airLineOne.getFlights().get(2);
//        flight.printFlight();
//        Passenger passenger = flight.getPlane().getPassengers().get(2);
//        passenger.printPassenger();
//        System.out.println("\nNum of Flights: " + airLineOne.getFlights().size());
//        System.out.println("Total pax: " + airLineOne.getPassengerTotal());

    }
}