/**
 * @author Valerie J. Smith
 * IT-145 Project 3
 * Instructor Osborne
 * April 15, 2020
 */


import java.util.ArrayList;

import java.util.Scanner;



public class Driver {

    // instance variables initiated as array lists for each set of data
    private static ArrayList<Ship> shipList = new ArrayList<Ship>();
    private static ArrayList<Cruise> cruiseList = new ArrayList<Cruise>();
    // Passenger list changes were not required for this assignment
    private static ArrayList<Passenger> passengerList = new ArrayList();
    
    

    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);
    	
    	 // add array list of ships to initialize method
        initializeShipList(shipList);      
         // add array list of cruises to initialize method
        initializeCruiseList(cruiseList);     
        // add array list of passengers to initialize method  
        initializePassengerList(passengerList);  

    	// call the display menu function
    	displayMenu();
    	
    	// set up the scanner to accept the user input for the menu
        String userSelection = scnr.next().toUpperCase();
        scnr.nextLine();

        // loop until the user chooses to exit
        // from best practices researched, a switch statement is commonly used for a menu as there 
        //  can be numerous iterations before the user is finished.
        while (!userSelection.equalsIgnoreCase("X")) {
        
            try {
                switch (userSelection) {
                    case "1":
                        addShip(scnr);
                        break;
                    case "2":
                        editShip();
                        break;
                    case "3":
                    	addCruise(scnr);
                        break;
                    case "4":
                        editCruise();
                        break;
                    case "5":
                        addPassenger();
                        break;
                    case "6":
                        editPassenger();
                        break;
                    case "A":
                        printShipList("name");
                        break;
                    case "B":
                        printShipList("active");
                        break;
                    case "C":
                        printShipList("full");
                        break;
                    case "D":
                        printCruiseList("list");
                        break;
                    case "E":
                        printCruiseList("details");
                        break;
                    case "F":
                        printPassengerList();
                        break;
                    case "X":
                        break;
                    default:
                        throw new Exception("Please try again with a valid selection.");
                }
            }
            catch (Exception excpt){
                System.out.println(excpt.getMessage());
            }

            displayMenu();
            userSelection = scnr.next().toUpperCase();
            scnr.nextLine();
        }

        System.out.println("Thanks for choosing Luxury Ocean Cruise Outings!");
        System.out.println("Y'all come back now!");
        scnr.close();   // close the scanner

        return;    
    }


    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList(ArrayList<Ship> shipList) {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, false);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
        add("Jolly Roger", 14, 20, 8, 30, true);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList(ArrayList<Cruise> cruiseList) {
    	add("Southern Swirl", "Candy Cane", "Greece", "Hogwarts", "Greece");
  
    }

	// hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList(ArrayList<Passenger> passengerList ) {
        Passenger newPassenger1 = new Passenger("Thor", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Loki", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Gamora", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }
    // custom method to add cruises to the cruiseList ArrayList
    public static void add(String tCruiseName, String tShipName, String tDeparture, String tDestination, String tReturn) {
        Cruise newCruise = new Cruise(tCruiseName, tShipName, tDeparture, tDestination, tReturn);
        cruiseList.add(newCruise);
    }

   //  code provided by assignment
    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        } else if (listType == "active") {
        	int activeShipCount = 0;
            System.out.println("\n\nSHIP LIST - Active");

            // complete this code block
            // loop through the shipList array list
            for (int i = 0; i < shipList.size(); i++) {
            	// find ships that are in service
                if (shipList.get(i).getInService()) {
                    System.out.println(shipList.get(i).toString()); 
                                                                    
                     // count in service ships                                             
                    activeShipCount++;  
                }
            }

            // tell the user that there are no active ships
            if (activeShipCount < 1) {
                System.out.println("Sorry, there are no Active Cruise Ships at this time.");
            }
                  

        } else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("\n-------------------------------------------------------");
            System.out.println("                    Number of Rooms               In");
            System.out.print("SHIP NAME           Bal\t OV\tSte\tInt\t  Service");
            System.out.println("\n-------------------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("                                     |-------------------PORTS--------------------------|"      );
            System.out.print("CRUISE NAME         SHIP NAME            DEPARTURE          DESTINATION          RETURN"             );
            System.out.println("\n----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

        System.out.println("\n\n");
        System.out.println("\t\t\tLuxury Ocean Cruise Outings");
        System.out.println("\t\t\t\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }
    


    // Add a New Ship
    public static void addShip(Scanner scnr) {
    	
    	// initialize variables
    	    String shipName = "";
    	    int roomBalcony;
    	    int roomOceanView;
    	    int roomSuite;
    	    int roomInterior;
    	    boolean inService = false;
    	    boolean valid = false;
    		String tempBalcony = "";
    		String tempOceanView = "";
    		String tempRoomSuite = "";
    		String tempRoomInterior = "";

        // complete this method
    	    // start the party here to get the ship name from the user
    	   	
            do {
             	 
       	   		
       	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
       	   	    System.out.print("Please enter the ship name: ");

                try {
                   shipName = scnr.nextLine();
              

                    for (int i = 0; i < shipList.size(); ++i) {
                        // cycle through the list of ship names to see if the name already exists
                        if (shipName.equalsIgnoreCase(shipList.get(i).getShipName())) {
                            valid = false;
        	   	    		throw new Exception("Ship name already exists.");

                        }
                    }	// ship name cannot be empty, it is a required field.
                    if (shipName.isEmpty()) {
                        throw new Exception ("Ship name is required!.  Please enter a valid ship name.");
                    }	// ship name cannot be just a number
                    if (shipName.matches("[0-9]+")) {
                        throw new Exception ("Ship name cannot be numeric.  Please enter a valid ship name.");
                    }
                    else {
                    	valid = true;
                    }

                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                
                }
            } while (!valid);
 
    	   	
    	   	// get the room balcony information 
    	   	
            do {
            	
             	 
       	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
       	   	    System.out.print("Please enter the number of balconies: ");
     

                try {
                     // setting number of balconies to a temporary string for validation purposes
             	     tempBalcony= scnr.nextLine();
               	    
             	     //  field cannot be empty and is required
                    if (tempBalcony.isEmpty()) {
                   	 valid = false;
                        throw new Exception ("Balconies are required! Please enter a valid number of Balconies.");
                    } // field needs to be 0 or above, no characters allowed
                    if (!tempBalcony.matches("[0-9]+")) {
                   	 valid = false;
                        throw new Exception ("The number of Balconies must be zero or a positive number. Please enter a valid number of Balconies.");
                    }
                    else {
                    	
                    	valid = true;
                    	
                    
                    }
                 

                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                
                }
                
            } while (!valid);
         
                	    
    	   	// get the room ocean view input
 	   	
            do {
            	
             	 
       	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
       	   	    System.out.print("Please enter the number of Ocean View rooms: ");
     

                try {
                	// setting temporary variable as a string for this input for validation purposes
             	     tempOceanView= scnr.nextLine();
               	    
                
             	     // field is required and cannot be empty
                    if (tempOceanView.isEmpty()) {
                   	 valid = false;
                        throw new Exception ("Ocean view rooms are required! Please enter a valid number of Ocean View Rooms.");
                    } //  field must be 0 or above, no negatives, no words or characters
                    if (!tempOceanView.matches("[0-9]+")) {
                   	 valid = false;
                        throw new Exception ("The number of Ocean view rooms must be zero or a positive number. Please enter a valid number of Ocean View Rooms.");
                    }
                    else {
                    	
                    	valid = true;
                    	
                    
                    }
                 

                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                
                }
                
            } while (!valid);
    	   	
    	   	
    	   	
    	   	// get the room suite input      	    

    	   	
            do {
            	
            	 
       	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
       	   	    System.out.print("Please enter the number of of Room Suites: ");
     

                try {
                  
             	     tempRoomSuite= scnr.nextLine();
               	    
             	     //  Room suites are a required field
                    if (tempRoomSuite.isEmpty()) {
                   	 valid = false;
                        throw new Exception ("Room Suites are required! Please enter a valid number of Room Suites.");
                    }  // there needs to be at least one room suite on a ship, even if it is the gallow
                    if (!tempRoomSuite.matches("[1-9]+")) {
                   	 valid = false;
                        throw new Exception ("The number of Room Suites must be a positive number greater than zero. Please enter a valid number of Room Suites.");
                    }
                    else {
                    	
                    	valid = true;
                    	
                    }
                 
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                
                }
                
            } while (!valid);
    	   	
    	   	// get the room interior

            do {
            	
       	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
       	   	    System.out.print("Please enter the number of Interior Rooms: ");
     

                try {
                	// temporarily reading this as a string for validation purposes.
             	     tempRoomInterior= scnr.nextLine();
               	    
             	     //  no empty returns allowed
                    if (tempRoomInterior.isEmpty()) {
                   	 valid = false;
                        throw new Exception ("Interior rooms are required! Please enter a valid number of Interior Rooms.");
                    } //  there has to be at least one interior room on a ship
                    if (!tempRoomInterior.matches("[1-9]+")) {
                   	 valid = false;
                        throw new Exception ("The number of Interior Rooms must be a positive number greater than zero. Please enter a valid number of Interior Rooms.");
                    }
                    else {
                    	
                    	valid = true;
                    	
                    
                    }
                 

                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                
                }
                
            } while (!valid);
    	   	
    	   	
    	   	
    	   	
    	   	
    	   	// get the room in service information
       	    
    	   	do {
    	   	    // if the user enters a string rather than a number, make them enter the right value.
    	   	    System.out.print("Please enter if the ship is in service( true or false): ");
    	   	    while (!scnr.hasNextBoolean()) {
    	   	        System.out.print("You must enter true or false only! Try again: ");
    	   	        scnr.next();
    	   	    }
    	        // catch the correct value as a boolean
    	   	    inService = scnr.nextBoolean();
    	   	    
    	   	        
    	   	} while (!valid);
    	   	
    	   	
    	   	
    	   	// set the instance variables to the temp variables
    	    roomBalcony =  Integer.parseInt(tempBalcony);
    	    roomOceanView = Integer.parseInt(tempOceanView);
    	    roomSuite = Integer.parseInt(tempRoomSuite);
    	    roomInterior = Integer.parseInt(tempRoomInterior);
    	    
    	   	// create a new ship with the data provided by the user

            Ship newShip = new Ship(shipName, roomBalcony, roomOceanView, roomSuite, roomInterior,inService);
            // add the new ship to the array list of ships
            shipList.add(newShip);
                 	    

    }

    // Edit an existing ship
    public static void editShip() {

        // This method does not need to be completed
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }

    // Add a New Cruise
    public static void addCruise(Scanner scnr) {
    	   String cruiseName = "";
    	   String cruiseShipName = "";
    	   String departurePort = "";
    	   String destination = "";
    	   String returnPort = "";
    	 

        // complete this method
   	    boolean valid = false;
   	    

       // complete this method
   	    // get the cruise name from the user
	   	
        do {
         	 
   	   		
   	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
   	   	    System.out.print("Please enter the Cruise name: ");

            try {
               cruiseName = scnr.nextLine();
          

                for (int i = 0; i < cruiseList.size(); ++i) {
                    // cycle through the list of cruise names to see if the name already exists
                    if (cruiseName.equalsIgnoreCase(cruiseList.get(i).getCruiseName())) {
                        valid = false;
    	   	    		throw new Exception("Cruise name already exists.");

                    }
                }
                if (cruiseName.isEmpty()) {
                    throw new Exception ("Cruise name is required! Please enter a valid Cruise name.");
                }
                if (cruiseName.matches("[0-9]+")) {
                    throw new Exception ("Cruise name cannot be numeric. Please enter a valid cruise name.");
                }
                else {
                	valid = true;
                }

            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            
            }
        } while (!valid);

   	   	
   	   	   	
     	  Boolean validCruiseEntry;

   	
        do {
         	  validCruiseEntry = true;
            
            
   	   		
   	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
   	   	    System.out.print("Please enter the Cruise ship name: ");

            try {
               cruiseShipName = scnr.nextLine();
          
               int  validShipCount = 0;
               Boolean shipInService = false;
               Boolean shipHasCruise = false;
               
               
               // loop through the array list of ship names to see if the ship name already exists
                for (int i = 0; i < shipList.size(); ++i) {

                    if (cruiseShipName.equalsIgnoreCase(shipList.get(i).getShipName())) {
                        validShipCount ++;
                        // check to see if ship is in service
                        if (shipList.get(i).getInService()) {
                            shipInService = true;
                        }
                        // if the ship is already assigned to a cruise
                        // throw an exception
                        shipHasCruise = hasCruise(cruiseShipName);
                    }
                }
                if (validShipCount == 0) {
                    throw new Exception ("Invalid ship name entry.  Please enter a valid ship name.");
                }
                if (!shipInService) {
                    throw new Exception("Invalid ship entry.  Ship is not in service.  Please enter a valid ship.");
                }
                if (shipHasCruise) {
                    throw new Exception("Invalid ship entry. Ship is already assigned to a cruise.  Please enter a valid ship.");
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
                validCruiseEntry = false;
            }
        } while (!validCruiseEntry);
        
        
     // get the departure port from the user  

	   	
         do {
          	 
    	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
    	   	    System.out.print("Please enter the Departure Port name: ");

             try {
                departurePort = scnr.nextLine();
           
                //  departure port is a required field
                 if (departurePort.isEmpty()) {
                	 valid = false;
                     throw new Exception ("Departure Port name is required!.  Please enter a valid Departure Port name.");
                 } // departure port cannot be numeric
                 if (departurePort.matches("[0-9]+")) {
                	 valid = false;
                     throw new Exception ("Departure Port name cannot be numeric.  Please enter a valid Departure Port name.");
                 }
                 else {
                 	valid = true;
                 }

             }
             catch (Exception ex) {
                 System.out.println(ex.getMessage());
             
             }
         } while (!valid);
   	     
  	            
	   	
   	   	     /// get the destination from the user   
   	    	        
		   		
		         do {
		          	 
		    	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
		    	   	    System.out.print("Please enter the Destination name: ");

		             try {
		                destination = scnr.nextLine();
		           
		                // destination name cannot be empty and is required
		                 if (destination.isEmpty()) {
		                	 valid = false;
		                     throw new Exception ("Destination name is required!.  Please enter a valid Destination name.");
		                 }	// destination name cannot be all numbers
		                 if (destination.matches("[0-9]+")) {
		                	 valid = false;
		                     throw new Exception ("Destination name cannot be numeric.  Please enter a valid Destination Port name.");
		                 }
		                 else {
		                 	valid = true;
		                 }

		             }
		             catch (Exception ex) {
		                 System.out.println(ex.getMessage());
		             
		             }
		         } while (!valid);
   	   	        
   	    	   	    
   	   	   	     /// get the return port from the user   
   	   	    	    
			         do {
			          	 
			    	   	    // if the user enters a number or symbols rather than a letters, make them enter the right value.
			    	   	    System.out.print("Please enter the Return Port name: ");

			             try {
			                returnPort = scnr.nextLine();
			           
			                // return port cannot be empty and is required
			                 if (returnPort.isEmpty()) {
			                	 valid = false;
			                     throw new Exception ("Return port name is required!.  Please enter a valid Return port name.");
			                 }	// return port cannot be all numbers
			                 if (returnPort.matches("[0-9]+")) {
			                	 valid = false;
			                     throw new Exception ("Return port name cannot be numeric.  Please enter a valid Return port name.");
			                 }
			                 else {
			                 	valid = true;
			                 }

			             }
			             catch (Exception ex) {
			                 System.out.println(ex.getMessage());
			             
			             }
			         } while (!valid);

        	   	
   	   	
   	   	
    	   //  create this new anotherCruise add anotherCruise to the Array list of cruises
	    	Cruise anotherCruise = new Cruise(cruiseName, cruiseShipName, departurePort, destination, returnPort);
	    	cruiseList.add(anotherCruise);
  
    }
    

    
  
    //  method to determine whether a ship is assigned to a cruise
    public static boolean hasCruise(String shipName) {
        boolean shipHasCruise = false;
        for (int i = 0; i < cruiseList.size(); ++i) {
            if (shipName.equalsIgnoreCase(cruiseList.get(i).getCruiseShipName())) {
                shipHasCruise = true;
            }
        }
        return shipHasCruise;
    }
    

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");

    }

    // Add a New Passenger
   public static void addPassenger() {

       Scanner newPassengerInput = new Scanner(System.in);
        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger: passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        for (Cruise eachCruise: cruiseList) {
           if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                // cruise does exist
            } else {
                System.out.println("That cruise does not exist in the system. Exiting to menu...");
               return; // quits addPassenger() method processing
            }
        }

        // get room type
        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
        String room = newPassengerInput.nextLine();
        // validate room type
        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
                (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
            // validation passed - add passenger
            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
            passengerList.add(newPassenger);
        } else {
            System.out.println("Invalid input. Exiting to menu...");
            return; // quits addPassenger() method processing
        }
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }



}
