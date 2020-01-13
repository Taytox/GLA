package dealership;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Abstract Vehicle class.
 * @author Euan Luke
 */
public abstract class Vehicle {
  protected String vehicleMake; 
  protected int vehicleYearMade;
  protected String vehicleModel;
  protected Colour vehicleColour;
  protected double vehicleMilage; 
  protected  String vehicleVIN;
  protected Gearbox vehicleGearType;
  protected ArrayList<PossibleAdditions> vehicleAdditions = new ArrayList<>();
   /**
    * Constructor of vehicle objects
    * @param make make of vehicle
    * @param model model of vehicle
    * @param yearMade year vehicle was made
    * @param colour colour of vehicle
    * @param milage milage of vehicle
    * @param VIN vehicle identification number
    * @param gearType gear box type of vehicle 
    * @param additions additions added to the vehicle
    */
   public Vehicle(String make, String model, int yearMade, Colour colour, double milage,String VIN,Gearbox gearType, PossibleAdditions... additions){
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
   
   /**
    * Sets the colour of a vehicle 
    * @param newColour colour to set
    */
   public void setColour(Colour newColour){
     vehicleColour = newColour; 
   }
   
   /**
    * Sets the Milage of a vehicle 
    * @param newMilage value to set milage to
    */
   public void setMilage(double newMilage){
       vehicleMilage = newMilage;
   }
   
   /**
    * Gets the make of the vehicle
    * @return make of the vehicle 
    */
   public String getMake(){
       return vehicleMake;
   }
   
   /**
    * gets the model of the vehicle
    * @return the model of the vehicle     
    */
   public String getModel(){
       return vehicleModel;
   }
   
   /**
    * gets the year the vehicle was made
    * @return the year the vehicle was made
    */
   public int getYearMade(){
      return vehicleYearMade;
   }
   
   /**
    * Gets the colour of the vehicle
    * @return the colour of the vehicle
    */
   public String getColour(){
       return this.vehicleColour.getDisplayName();
   }
   
   /**
    * Gets the gearbox type of the vehicle
    * @return the gearbox type of the vehicle
    */
   public String getGearType(){
       return this.vehicleGearType.getDisplayName();
   }
   
   /**
    * Gets the Vehicle Identification number of the vehicle
    * @return the Vehicle Identification number of the vehicle
    */
   public String getVIN(){
        return vehicleVIN;
    }
 
   /**
    * Builds a string of all the additions the vehicle has. 
    * @return string of additions the vehicle has. 
    */
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
    
    /**
     * Allows additions to be added to the vehicle, is blank and overwritten in subclasses. 
     * @param addition addition to add
     */
    protected void addAddition(PossibleAdditions addition){
        //Empty on purpose, overwritten in subclasses. 
    }
     
     
      }

