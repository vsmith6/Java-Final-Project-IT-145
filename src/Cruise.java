    /**
     * @author Valerie J. Smith
     * IT-145 Project 3
     * Instructor Osborne
     * April 15, 2020
     */
public class Cruise {

    // Instance Variables
    private String cruiseName;
    private String cruiseShipName;
    private String departurePort;
    private String destination;
    private String returnPort;

    // Constructor - default
    Cruise() {
    }

    // Constructor - full
    Cruise(String tCruiseName, String tShipName, String tDeparture, String tDestination, String tReturn) {
        cruiseName = tCruiseName;
        cruiseShipName = tShipName;
        departurePort = tDeparture;
        destination = tDestination;
        returnPort = tReturn;
    }

    // Accessors
    public String getCruiseName() {
        return cruiseName;
    }

    public String getCruiseShipName() {
        return cruiseShipName;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getDestination() {
        return destination;
    }

    public String getReturnPort() {
        return returnPort;
    }

    // Mutators
    public void setCruiseName(String tVar) {
        cruiseName = tVar;
    }

    public void setCruiseShipName(String tVar) {
        cruiseShipName = tVar;
    }

    public void setDeparturePort(String tVar) {
        departurePort = tVar;
    }

    public void setDestination(String tVar) {
        destination = tVar;
    }

    public void setReturnPort(String tVar) {
        returnPort = tVar;
    }

    // print cruise details

    public void printCruiseDetails() {

        // complete this method
    	// copied over from Ship method as given, but applied information from passenger file to print
    	// set up a counter and evenly space the columns apart minus their name length
        int spaceCount;
        String spaces1 = "";
        String spaces2 = "";
        String spaces3 = "";
        String spaces4 = "";
        spaceCount = 20 - cruiseName.length();
        for (int i = 1; i <= spaceCount; i++) {
            spaces1 = spaces1 + " ";
        }
        spaceCount = 20 - cruiseShipName.length();
        for (int i = 1; i <= spaceCount; i++) {
            spaces2 = spaces2 + " ";
        }
        spaceCount = 20 - departurePort.length();
        for (int i = 1; i <= spaceCount; i++) {
            spaces3 = spaces3 + " ";
        }
        spaceCount = 20 - destination.length();
        for (int i = 1; i <= spaceCount; i++) {
            spaces4 = spaces4 + " ";
        }
        
        
        
        
        // print out all of the fields for the cruise list
        System.out.println( cruiseName + spaces1  + cruiseShipName + spaces2 + departurePort+ spaces3 + destination + spaces4  + returnPort);

    }

    // method added to print cruise's name vice memory address
    @Override
    public String toString() {
    	  return cruiseName;
    }
}
