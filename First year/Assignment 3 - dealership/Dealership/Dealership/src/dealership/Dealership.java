/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;


import Core.util.IOHelper;
import java.util.ArrayList;
import Core.util.FileManager;

/**
 * Dealership class, used to create and manage vehicle objects. 
 * @author Euan Luke
 */
public class Dealership {
    static ArrayList<Vehicle> stock = new ArrayList<Vehicle>(); //used to hold current stock. 
    static boolean unSavedChanges = false; //used to store if any changes have been made to stock items but the save method has not been called. 
    
  /**
   * Main method of dealership class.
   * @param args 
   */
    public static void main(String[] args) {
        boolean exit = false;
        String VIN;
        loadStock(); // load any stock held in Stock.txt
        
        while(exit == false){
            int choice = IOHelper.getMenuChoice("Dealership Menu : ","Stock actions","Exit"); //Displays Main Menu 
            switch(choice){
                case(1): // User selects list all stock
                    listAllStock();
                    choice = IOHelper.getMenuChoice("Stock actions : ","Add new Vehicle","Open Vehicle page","Save","Back To menu"); //displays stock actions menu 
                    switch(choice){
                        case(1):
                            getNewVehicleDetails(); //user selects add new vehicle
                            break;
                        case(2):
                            VIN = IOHelper.getString("Please enter the VIN of the vehicle you want to open",17,17); //user selects open Vehicle Page
                            if (isVehicleInStock(VIN)){
                               displayVehiclePage(VIN); 
                            }
                            break;
                        case(3):
                            saveStock();
                            break;
                    }
                    break;
                case(2): 
                    if(unSavedChanges){ //if user tries to exit but hasn't saved. 
                          if(IOHelper.getYesNo("You have unsaved changes, do you want to save? "))
                              saveStock();
                          else{
                              exit = true;
                          }
                    }
                     exit = true;
                        //Display Sales not yet coded.
                    break;   
            }
        }   
    }
    
    /**
     * Prompts user to enter the details required to make a new vehicle object
     */
    public static void getNewVehicleDetails(){
    
    
    String make;
    String model;
    String type;
    int year;
    int milage;
    int index = 0;
    boolean uniqueVIN = false;
    String VIN = null;
    Colour colour  = null;
    Colour AllColours[] = Colour.values();
    String[] colourOptions = new String[AllColours.length];
    Gearbox gearBox = null; 
    Boolean satNav = false;
    Boolean parkingSensor = false;
    Boolean towBar = false;
    Boolean roofRack = false;
    Boolean allWheelDriveTrain = false;
    Boolean thirdRowSeat = false;
    Boolean luggageBox = false;
    /*
    Build String array containing all colours supported by the Colour Enum. 
    */
    for(Colour C : AllColours){
       colourOptions[index] = C.toString();
        index++;
    }
    /*
    Collect required information from the user. 
    */
    type = IOHelper.getMultipleChoiceAnswer("Which type of Vehicle is it?", "Estate", "Hatchback", "Saloon","Suv","Motorbike");
    make = IOHelper.getString("Please enter the Maker of the vehicle : ",1,15);
    model = IOHelper.getString("Please enter the model of the vehicle : ",1,15);
    year = IOHelper.getNumberInRange("What year was the vehicle made(Must be after 1970)", 1970, 2019);
    milage = IOHelper.getNumberInRange("Please enter the milage of the vehicle",0,1000000);
    /*
    Checks that the VIN entered is Unique.
    */
    while(!uniqueVIN){
    VIN = IOHelper.getString("Please enter the VIN of the vehicle",17,17);
    for(Vehicle i : stock){
      if(i.getVIN().equalsIgnoreCase(VIN)){
          System.out.print("A Vehicle with this VIN is already in stock");
          break;
      }else{
                  uniqueVIN=true;
                  }

    }
    }
    /**
     * converts strings to their enum values. 
     */
    colour = Colour.valueOf(IOHelper.getMultipleChoiceAnswer("What colour is this vehicle?",colourOptions));
    gearBox = Gearbox.valueOf(IOHelper.getMultipleChoiceAnswer("What type of gearbox does it have?","MANUAL","AUTOMATIC"));
    
    /*
    if the vehicle has additional options, goes through setting the required booleans based on answers from user. 
    */
    if(IOHelper.getYesNo("Does this vehicle have any additional options?")){
        if(type.equals("Motorbike")){
            luggageBox = IOHelper.getYesNo("Does this bike have a luggagebox?");
        }
        else{
            satNav = IOHelper.getYesNo("Does this car have a Sat Nav?");
            parkingSensor = IOHelper.getYesNo("Does this car have a parking Sensor");
            towBar = IOHelper.getYesNo("Does this car have a tow Bar");
            roofRack = IOHelper.getYesNo("Does this car have a roof Rack");  
        }
        if(type.equals("Suv")){
           allWheelDriveTrain = IOHelper.getYesNo("Does this car have all wheel drive?");
        }
        if(type.equals("Estate")){
            thirdRowSeat = IOHelper.getYesNo("Does this car have a third row seat");
        }
    }
    /*
     * Add the new vehicle to stock
     */
    addVehicleToStock(type,make,model,year,colour,milage,VIN,gearBox,satNav,parkingSensor,towBar,roofRack,allWheelDriveTrain,thirdRowSeat,luggageBox);
    }
    
    /**
     *  Creates vehicle objects and adds them to stock. 
     * @param type type of vehicle required. 
     * @param make make of the vehicle
     * @param model model of the vehicle
     * @param year year the vehicle was made
     * @param colour colour of the vehicle 
     * @param milage milage the vehicle has
     * @param VIN VIN of the vehicle
     * @param gearBox gearbox type of the vehicle 
     * @param satNav does the vehicle have a satnav
     * @param parkingSensor does the vehicle have a parking sensor  
     * @param towBar does the vehicle have a towBar
     * @param roofRack does the vehicle have a RoofRack
     * @param allWheelDriveTrain does the vehicle have all wheel drive
     * @param thirdRowSeat does the vehicle have a third row seat
     * @param luggageBox  does the vehicle have a luggage box
     */
    public static void addVehicleToStock(String type, String make, String model, int year, Colour colour, int milage, String VIN, Gearbox gearBox,boolean satNav, boolean parkingSensor, boolean towBar,boolean roofRack,boolean allWheelDriveTrain,boolean thirdRowSeat,boolean luggageBox){
    switch(type){
        case("Estate"):
            stock.add(new Estate(make,model,year,colour,milage,VIN,gearBox,satNav,parkingSensor,towBar,roofRack,thirdRowSeat));
             break;
        case("Hatchback"):
            stock.add(new Hatchback(make,model,year,colour,milage,VIN,gearBox,satNav,parkingSensor,towBar,roofRack));
             break;
        case("Saloon"):
            stock.add(new Saloon(make,model,year,colour,milage,VIN,gearBox,satNav,parkingSensor,towBar,roofRack));
             break;
        case("Suv"):
            stock.add(new Suv(make,model,year,colour,milage,VIN,gearBox,satNav,parkingSensor,towBar,roofRack,allWheelDriveTrain));
             break;
        case("Motorbike"):
            stock.add(new Motorbike(make,model,year,colour,milage,VIN,gearBox,luggageBox));
             break;
    }
    unSavedChanges = true;
    }
    
/**
 * Loads stock held in Resources\Stock.txt
 */
    public static void loadStock(){
       ArrayList<String> bufferAL = new ArrayList<String>();
       String[] details = new String[15];
       int year;
       int milage;
       Colour colour = null;
       Gearbox gearBox = null;      
        bufferAL = FileManager.getFileByLine("Resources\\Stock.txt");
        /**
         * need to match up the strings from the txt file with the variables required for the constructors. 
         */
        for(String i : bufferAL){
            details = i.split("\\|");
            year = Integer.parseInt(details[3]);
            colour = Colour.valueOf(details[4]);
            milage = Integer.parseInt(details[5]);
            gearBox = Gearbox.valueOf(details[7]);
            addVehicleToStock(details[0],details[1],details[2],year,colour,milage,details[6],gearBox,Boolean.parseBoolean(details[8]),Boolean.parseBoolean(details[9]),Boolean.parseBoolean(details[10]),Boolean.parseBoolean(details[11]),Boolean.parseBoolean(details[12]),Boolean.parseBoolean(details[13]),Boolean.parseBoolean(details[14]));
        }
        
        
        
        
    }
    
    /**
     * Prepares the content of Stock array and writes them to Resources\Stock.txt
     */
    public static void saveStock(){
        ArrayList<String> bufferAL = new ArrayList<String>();
        String currentVehicle;
        String[] details = new String[9];
        String vehicleType;
        String make;
        String model;
        String year;
        String colour;
        String milage;
        String VIN;
        String gearBox;
      
        /*
        For each vehicle in stock, need to build a string to be written. 
        */
        for(Vehicle i : stock){
        Boolean satNav = false;
        Boolean parkingSensor = false;
        Boolean towBar = false;
        Boolean roofRack = false;
        Boolean allWheelDriveTrain = false;
        Boolean thirdRowSeat = false;
        Boolean luggageBox = false;
            currentVehicle = i.toString();
            details = currentVehicle.split("\\|");
            
            /*
            Remove the trailing spaces from each string. 
            */
            for(int index = 0;index<7; index++){
            details[index]=details[index].trim();
            }

            VIN = details[0];
            make = details[1];
            model = details[2];
            year = details[3];
            milage = details[4];
            colour= details[5];
            gearBox = details[6];
            
      
  
            /*
            Because the .toString gives one string including all additions, need to find out which additions this vehicle has. 
            */
            if(details[7].contains("Satnav")){
                satNav = true;
            }
            if(details[7].contains("Parking Sensor")){
                parkingSensor = true;
            }
            if(details[7].contains("Towbar")){
                towBar = true;
            }
            if(details[7].contains("Roofrack")){
                roofRack = true;
            }
            if(details[7].contains("All Wheel Drive Train")){
                allWheelDriveTrain = true;
            }
            if(details[7].contains("Third row seat")){
                thirdRowSeat = true;
            }
            if(details[7].contains("Luggage box")){
                luggageBox = true;
            }
            vehicleType = i.getClass().getName().substring(11); //Need to get what type of Vehicle it is, classname is prefixed by package name so need to cut that off. 
        bufferAL.add(vehicleType+"|"+make+"|"+model+"|"+year+"|"+colour+"|"+milage+"|"+VIN+"|"+gearBox+"|"+String.valueOf(satNav)+"|"+String.valueOf(parkingSensor)+"|"+String.valueOf(towBar)+"|"+String.valueOf(roofRack)+"|"+String.valueOf(allWheelDriveTrain)+"|"+String.valueOf(thirdRowSeat)+"|"+String.valueOf(luggageBox));
        //System.out.println(details[0]+"|"+details[1]+"|"+details[2]+"|"+details[3]+"|"+details[4]+"|"+details[5]+"|"+String.valueOf(satNav)+"|"+String.valueOf(parkingSensor)+"|"+String.valueOf(towBar)+"|"+String.valueOf(roofRack)+"|"+String.valueOf(allWheelDriveTrain)+"|"+String.valueOf(thirdRowSeat)+"|"+String.valueOf(luggageBox));
        
        }
      FileManager.writeFileByLine("Resources\\Stock.txt", bufferAL);
      unSavedChanges = false;
    }
    
    /**
     * Prints the header used when displaying stock items. 
     */
    private static void printStockHeader(){
    System.out.printf("%-160S%n","\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");    
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n", "VIN", "Make", "Model","Year", "Milage", "Colur","Gearbox Type","Additions");
    System.out.printf("%-160S%n","------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    /**
     * Lists the vehicles currently in stock
     */
    public static void listAllStock(){
    printStockHeader();
        for(Vehicle i : stock){
            printVehicleDetails(i);
        }
    }
    
    /**
     * Prints the details of a single stock item based on VIN
     * @param VIN 
     */
    public static void listSingleItem(String VIN){
       if(isVehicleInStock(VIN)){
           printStockHeader();
           printVehicleDetails(findVehicleInStock(VIN));
    } 
    }
    
    
    /**
     * Checks if a vehicle is in stock
     * @param VIN VIN of the number to check for
     * @return <code>True</code> if it is in stock, <code>False </code> if not
     */
    private static  boolean isVehicleInStock(String VIN){
        for (Vehicle i : stock){
            if (i.getVIN().equals(VIN)){
                return true;
            } 
        }
        System.out.println("\nThis vehicle (VIN: " + VIN + ") is not in stock");  
        return false; 
    }
    
    /**
     * Finds and returns an item from Stock
     * @param VIN
     * @return 
     */
    private static Vehicle findVehicleInStock(String VIN){
        for (Vehicle i : stock){
            if (i.getVIN().equals(VIN)){
                return i;
            } 
        }
        return null;
    }
    
    /**
     * Prints the details for a Vehicle..
     * @param i the vehicle to print info for.
     */
    private static void printVehicleDetails(Vehicle i){
    String[] details = new String[8];
    details = i.toString().split("\\|");
    if(details[7].isBlank()){
        details[7] = "  None";
    }
        
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-18s %-40s%n", details[0],details[1],details[2],details[3],details[4],details[5],details[6],details[7]);
    
    }
 
    /**
     * Checks if vehicle is an instance of motorbike
     * @param toBeTested vehicle to be checked
     * @return <code>true</code> if motorbike, <code>false</code> if Car
     */
    private static String typeOfVehicle(Vehicle toBeTested){
        if (toBeTested instanceof Motorbike){//if the object is an instance of motorbike
            return "Motorbike";
        }
        else{//if the object is an instance of SUV
            return "Car";
        }
    }

    /**
     * Removes an Item from Stock
     * @param toBeModified Vehicle to be removed.
     */
    private static void sellVehicle(Vehicle toBeModified){
      
        stock.remove(toBeModified);
        unSavedChanges = true;
        }
    
 /**
  * Displays the vehicle page for a single vehicle  
  * @param VIN The VIN of the Vehicle to open.
  */
    private static void displayVehiclePage(String VIN){
        int choice = 0;
        
        Vehicle openPage = findVehicleInStock(VIN);
        
        while (choice!=4){
            listSingleItem(VIN);
        choice = IOHelper.getMenuChoice("Vehicle options", "Change Colour", "Add or Remove additions", "Sell Vehicle", "Back to menu");
            switch(choice){
                case(1):modifyVehicleColour(openPage);
                        break;
                case(2):modifyVehicleAdditions(openPage);
                        break;
                case(3):sellVehicle(openPage);
                        choice = 4;
                        break;
 
            }
                            
        }
        
        
        
    }
    
    /**
     * Allows a colour of a vehicle to be changed.
     * @param toBeModified vehicle to modify
     */
    private static void modifyVehicleColour(Vehicle toBeModified){
        Colour currentColour;
        Colour[] allAvailableColours;
        int index = 0;
        String choice; 
        
        /**
         * gets the current colour, the gets the user to pick from all other colours./
         */
        currentColour = toBeModified.getColour();
        allAvailableColours = Colour.values();
        String[] availableColours = new String[allAvailableColours.length -1]; 
        
        for(Colour c : allAvailableColours){
            if(c != currentColour){
                availableColours[index] = c.toString();
                index++;
            } 
        }
       choice = IOHelper.getMultipleChoiceAnswer("The Possible colours are :", availableColours);
       toBeModified.setColour(Colour.valueOf(choice));
        unSavedChanges = true;
    }
    
    /**
     * Allows additions to be added and removed from Vehicles. 
     * @param toBeModified 
     */
    private static void modifyVehicleAdditions(Vehicle toBeModified){
    String choice;
    String vehicleType;
    vehicleType = typeOfVehicle(toBeModified);
    String[] additions = toBeModified.possibleadditions().split("\\|");
    
    
    if (vehicleType.equals("Car")){
        if(additions[0].equals("")){
            System.out.println("\nNo available additions ");
        }
        else{   
            choice = IOHelper.getMultipleChoiceAnswer("The Possible additions are: ", additions);
            toBeModified.modifyVehicle(choice);
        }
    }else if(vehicleType.equals("Motorbike")){
        if(additions[0].equals("")){
            choice = IOHelper.getMultipleChoiceAnswer("This bike already has a luggage box, would you like to remove it?  ", "Yes", "No");
            if (choice.equals("Yes")){
               toBeModified.modifyVehicle("remove");
            }
        } 
        else{   
            choice = IOHelper.getMultipleChoiceAnswer("The Possible additions are: ", additions);
            toBeModified.modifyVehicle(choice);
        }
    }
unSavedChanges = true;
    }
}
