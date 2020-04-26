/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 * SUV class which extends Car
 * @author Euan Luke
 */
public class Suv extends Car{
    
    private boolean hasAllWheelDriveTrain;

/**
 * Constructor for SUV class 
 * @param make make of SUV
 * @param model Model of SUV
 * @param yearMade Year SUV was made
 * @param colour Colour of the SUV  
 * @param milage milage of the SUV
 * @param VIN Vehicle Identification Number of SUV  
 * @param gearType Gearbox Type of SUV
 * @param satNav
 * @param parkingSensor
 * @param towBar
 * @param roofRack
 * @param allWheelDriveTrain
 */
    
    public Suv(String make, String model, int yearMade, Colour colour, int milage, String VIN, Gearbox gearType, boolean satNav, boolean parkingSensor, boolean towBar, boolean roofRack, boolean allWheelDriveTrain) {
        super(make, model, yearMade, colour, milage, VIN, gearType, satNav, parkingSensor, towBar, roofRack);
        
    hasAllWheelDriveTrain = allWheelDriveTrain;
    
    }
    public void addAllWheelDriveTrain() {
       hasAllWheelDriveTrain = true;
    }
    @Override
    public String toString() {
        String carAdditions;
        if(hasAllWheelDriveTrain){
            return super.toString() + " All Wheel Drive Train";
            }
         return super.toString();
    }
    @Override
    public String possibleadditions(){
        String additions = super.possibleadditions();
        if(!hasAllWheelDriveTrain){
            additions = additions + "All Wheel Drive Train|";
        }
        return additions;
 
    }
    /**
     * Manages additions being changed. 
     * @param Addition addition to be added.
     */
    @Override 
    public void modifyVehicle(String Addition){
    
        switch(Addition){
            case("All Wheel Drive Train"):
                addAllWheelDriveTrain();
                break;
        }
         super.modifyVehicle(Addition);
      
    } 
}


