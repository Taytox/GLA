/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 * Motorbike class which extends Vehicle 
 * @author Euan Luke
 */
public class Motorbike extends Vehicle {
    
/**
 *  Constructor for Motorbike class
 * 
 * @param make make of the motorbike
 * @param model model of the motorbike
 * @param yearMade year the motorbike was made
 * @param colour colour of the motorbike
 * @param milage milage of the motorbike
 * @param VIN Vehicle Identification Number of the motorbike
 * @param gearType gearbox type of the motorbike
 * @param additions additions added to the motorbike
 */
    public Motorbike(String make, String model, int yearMade, Colour colour, double milage, String VIN, Gearbox gearType, PossibleAdditions... additions) {
        super(make, model, yearMade, colour, milage, VIN, gearType, additions);
    }
    
    
    /**
     * Allows additions to be added to motorbike objects
     * 
     * @param addition  addition to be added
     */
    @Override
    protected void addAddition(PossibleAdditions addition){
        
        if (vehicleAdditions.contains(addition)){
                System.out.println("This bike already has this addition");
        }
        else
        {
        switch(addition){
                case LUGGAGEBOX:
                    System.out.println("Luggage box added");
                    vehicleAdditions.add(addition);
                    break;
                default: 
                    System.out.println("This addition is not suitable for this vehicle");
                    break;
        }
        
        
    }
    }
    /**
     * Allows additions to be removed from Motorbike Objects
     * 
     * @param addition Addition to be removed.  
     */
    protected void removeAddition(PossibleAdditions addition){
        
        if (!vehicleAdditions.contains(addition)){
                System.out.println("This bike does not have that addition");
        } 
        else
        {
          vehicleAdditions.remove(addition);  
        }
}
}