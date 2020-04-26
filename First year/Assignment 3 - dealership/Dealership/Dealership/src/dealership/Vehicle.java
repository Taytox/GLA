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
  private final String vehicleMake; 
  private final int vehicleYearMade;
  private final String vehicleModel;
  private Colour vehicleColour;
  private int vehicleMilage; 
  private final String vehicleVIN;
  private final Gearbox vehicleGearType;
   /**
    * Constructor of vehicle objects
    * @param make make of vehicle
    * @param model model of vehicle
    * @param yearMade year vehicle was made
    * @param colour colour of vehicle
    * @param milage milage of vehicle
    * @param VIN vehicle identification number
    * @param gearType gear box type of vehicle 
    */
   public Vehicle(String make, String model, int yearMade, Colour colour, int milage,String VIN,Gearbox gearType){
    vehicleMake = make;
    vehicleModel = model;
    vehicleYearMade = yearMade;
    vehicleColour = colour;
    vehicleMilage = milage; 
    vehicleVIN = VIN;
    vehicleGearType = gearType;
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
   public void setMilage(int newMilage){
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
   public Colour getColour(){
       return vehicleColour;
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
   
    @Override
    public String toString() {
        return vehicleVIN+ " |" + vehicleMake+ " |" +vehicleModel+ " |" +vehicleYearMade+ " |" + vehicleMilage+ " |" +vehicleColour.toString()+ " |" +vehicleGearType+ " | ";
    }
   
    public String possibleadditions(){
        return ""; 
    }
   public void modifyVehicle(String Addition){
       //overwritten in Child Classes. 
   }
}


