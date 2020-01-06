package dealership;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Euan Luke
 */
public abstract class Vehicle {
  protected String vehicleMake;
  protected int vehicleYearMade;
  protected String vehicleModel;
  protected Colour vehicleColour;
  protected double vehicleMilage; 
  protected  int vehicleVIN;
  protected Gearbox vehicleGearType;
  protected ArrayList<PossibleAdditions> vehicleAdditions = new ArrayList<PossibleAdditions>();
   
   public Vehicle(String make, String model, int yearMade, Colour colour, double milage,int VIN,Gearbox gearType, PossibleAdditions... additions){
    vehicleMake = make;
    vehicleModel = model;
    vehicleYearMade = yearMade;
    vehicleColour = colour;
    vehicleMilage = milage; 
    vehicleVIN = VIN;
    vehicleGearType = gearType;
    int counter = 0;
    while (counter < additions.length){
        vehicleAdditions.add(additions[counter]);
        counter++;
    }
   }
   
   public void setColour(Colour newColour){
     vehicleColour = newColour; 
   }
   
   public void setMilage(double newMilage){
       vehicleMilage = newMilage;
   }
   
   public String getMake(){
       return vehicleMake;
   }
   
   public String getModel(){
       return vehicleModel;
   }
   
   public int getYearMade(){
      return vehicleYearMade;
   }
   
   public String getColour(){
       return this.vehicleColour.getDisplayName();
   }
   
   public String getGearType(){
       return this.vehicleGearType.getDisplayName();
   }
   
   public int getVIN(){
        return vehicleVIN;
    }
   
   /**
     *  Prints a list of the current additions that a vehicle has 
     */
    protected void checkForAddition(){
    int count = 0;
    System.out.print("This Vechicle has the following addtions :");
    while (count < vehicleAdditions.size()) {
       System.out.print(vehicleAdditions.get(count).getDisplayName()); 
       count++;
    }
    }
   
    protected String getAdditionsList(){
    int counter = 0; 
    String additions = "";
    
    if (vehicleAdditions.size() > 0){
        while(counter < vehicleAdditions.size()){
        additions = additions + " " + vehicleAdditions.get(counter).getDisplayName();
        counter++;
        }
    }
    else{
    additions = "None";
    }
    
    return additions;
    }
    
     
     
      }

