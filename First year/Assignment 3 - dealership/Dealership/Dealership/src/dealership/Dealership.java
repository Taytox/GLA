/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Dealership class, used to create and manage vehicle objects. 
 * @author Euan Luke
 */
public class Dealership {
    static ArrayList<Vehicle> stock = new ArrayList<Vehicle>();
    static Scanner sc = new Scanner(System.in);
    /**
     * main method for package. 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean exit = false;
        int choice;
        String VIN;
        addStock();
        while(exit == false){
            displayMenu(1);
            choice = getValidNumber(1,3);
            switch(choice){
                case(1): // User selects list stock
                    listStock();
                    break;
                case(2): // User selects modify vehicle
                    listStock(); //added to make VIN choice easier. 
                    displayMenu(2);
                    VIN = getValidVIN();
                    modifyVehicle(VIN);
                    break;
                case(3): // user selects exit 
                    exit = true;
            }
    }
       }
    
    /**
     * Adds demo vehicles into stock
     */
    public static void addStock(){
      
        
        
        stock.add(new Hatchback("Ford","Focus",2016,Colour.BLUE,10000,"1HGBH41JXMN109186",Gearbox.MANUAL,PossibleAdditions.SATNAV,PossibleAdditions.PARKINGSENSOR,PossibleAdditions.TOWBAR));
        stock.add(new Estate("Audi","RS6",2013,Colour.BLACK,50000,"1RTGY72HYNH824926",Gearbox.MANUAL,PossibleAdditions.SATNAV));
        stock.add(new Saloon("Mercedes-Benz","C-Class",2015,Colour.RED,13000,"7YJVN85REYG264862",Gearbox.AUTOMATIC));
        stock.add(new Suv("Land Rover","Range Rover",2000,Colour.GREEN,73000,"5UNHF65YREN850584",Gearbox.AUTOMATIC,PossibleAdditions.TOWBAR,PossibleAdditions.ROOFRACK));
        stock.add(new Motorbike("Harley-Davidson","Iron 883",2018,Colour.BLACK,11000,"1NJYC65HEMT185403",Gearbox.MANUAL));
        
        
    }
    
    /**
     * Lists the vehicles currently in stock
     */
    public static void listStock(){
    
        System.out.println("\nCurrent Stock");
        System.out.format("|%-20s|%-16s|%-16s|%-16s|%-16s|%-16s|%-32s|%n","VIN", "Make", "Model","Year","Colour","Gearbox", "Additions"); //used to format headings to get them into a table output. 
        for (Vehicle i : stock){
            getVehicleDetails(i);  
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
            System.out.println("No Vehicle matches this VIN");  
            return false; 
    }
    
    /**
     * Prints the details of a particular vehicle
     * @param i vehicle object to print details for
     */
    public static void getVehicleDetails(Vehicle i){
           System.out.format("|%-20s|%-16s|%-16s|%-16d|%-16s|%-16s|%-32s|%n", i.getVIN(),i.getMake(),i.getModel(),i.getYearMade(),i.getColour(),i.getGearType(),i.getAdditionsList()); //formats output into a table layout
    }   
     
    /**
     * Finds the index for a vehicle held in Stock
     * @param VIN VIN of vehicle to find
     * @return index number for vehicle
     */
    private static Vehicle findStockLocation(String VIN){
        for (Vehicle i: stock){
            if(i.getVIN().equals(VIN)){
                return i;
            }
     }
        return null;
    }
    
    /**
     * Checks if vehicle is an instance of motorbike
     * @param toBeTested vehicle to be checked
     * @return <code>true</code> if motorbike, <code>false</code> if Car
     */
    private static boolean isMotorBike(Vehicle toBeTested){
        if(toBeTested instanceof Motorbike){ //if the object is an instance of motorbike
           return true; 
        }
        else {
            return false;
        }
    }
    
    /**
     * Allows vehicles in stock to be modified
     * @param VIN VIN of the vehicle to be modified
     * @param addition the addition to be added or removed
     */
    private static void modifyVehicle(String VIN){
        Vehicle toBeModified;
       PossibleAdditions addition;
        toBeModified = findStockLocation(VIN);
        if(isMotorBike(toBeModified)){
            displayMenu(3);
            int choice = getValidNumber(1,2);
            
            switch(choice){
                case(1): // user chooses to add an addition
                    addition = getAdditionChoice();
                    toBeModified.addAddition(addition);
                    break;
                case(2): //user chooses to remove an addition.
                    addition = getAdditionChoice();
                    ((Motorbike)toBeModified).removeAddition(addition);
                    break;
                default:
                    break;
            }
        }
         else{
        addition = getAdditionChoice();        
         toBeModified.addAddition(addition);
        }
         
    }
    
    /**
 * Gets valid number. 
 * @param minimum minimum valid choice
 * @param maximum minimum valid choice
 * @return returns the valid number
 */
    private static int getValidNumber(int minimum, int maximum){
    int input = 0;
    boolean validInput = false; 
    while (!validInput){
    while (!sc.hasNextDouble()){
        System.out.print("\nPlease enter a number between " + minimum + " and "+ maximum + " : ");
        sc.next(); //if a number was not entered, clear buffer and take next input; 
    }
    input = sc.nextInt();
    
     if (input >= minimum && input <= maximum){
            validInput = true; 
            }
        else {
        System.out.print("\nPlease enter a number between " + minimum + " and "+ maximum + " : ");
        }
}
    
    return input;
}
    
    /**
     * Displays menus 
     * @param menuCode code of the menu to show
     */
    private static void displayMenu(int menuCode){
        switch(menuCode){
            case(1):
                System.out.println();
                System.out.println("1. List stock");
                System.out.println("2. Modify vehicle");
                System.out.println("3. Exit");
                System.out.println();
                System.out.print("Enter your choice : ");
                break;
            case(2):
                System.out.println();
                System.out.print("Enter the VIM of the vehicle you want to modify : ");
                System.out.println();
                break;
            case(3):
                System.out.println();
                System.out.println("Would you like to add or remove an addition?");
                System.out.println("1. Add 2. Remove");
                break;
                    
        
    }
    }
    
    /**
     * Gets a valid VIN from the user 
     * @return the valid VIN number for a vehicle in stock 
     */
    private static String getValidVIN(){
        Boolean validVIN = false;
        while(!validVIN){
        String VIN = sc.next();
        if(isVehicleInStock(VIN)){
            return VIN;
        } 
        else
        {
            System.out.println();
            System.out.print("Please enter a valid VIN : ");
        }
}
        return null;
}
    
    /**
     * Gets a choice of addition from the user
     * @return the addition to be added
     */
    private static PossibleAdditions getAdditionChoice(){
        int choice; 
        PossibleAdditions addition;
        int optionNumber = 1;
        System.out.println();
        for(PossibleAdditions i : PossibleAdditions.values()){
            System.out.println(optionNumber + " " + i.getDisplayName());
            optionNumber ++; 
        }
        System.out.println();
        System.out.print("Please select an addition : ");
        choice = getValidNumber(1,7);
        choice = choice -1;  // because enum starts at 0, have to take 1 from choice to find the real int needed. 

        return PossibleAdditions.values()[choice];
        
}
}
