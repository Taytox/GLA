/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 * abstract car class that extends Vehicle class
 * @author Euan Luke
 */
public abstract class Car extends Vehicle {

    
    
/**
 *  Constructor for Car objects
 * @param make make of car 
 * @param model model of car
 * @param yearMade year car was made
 * @param colour colour of car
 * @param milage milage of car
 * @param VIN Vehicle Identification number of car
 * @param gearType gearbox type of the car
 * @param additions additions added to the car
 */
    public Car(String make, String model, int yearMade, Colour colour,double milage, String VIN, Gearbox gearType, PossibleAdditions... additions) {
        super(make, model, yearMade, colour, milage, VIN, gearType, additions);
   
    }
    /**
     * Changes the additions of a car 
     * @param addition the addition to add.
     */
    @Override
    protected void addAddition(PossibleAdditions addition){
       
        if (vehicleAdditions.contains(addition)){
           System.out.println("This car already has this addition");
        }
        else
        {
            switch(addition){
                case SATNAV:
                    System.out.println("Adding sat Nav. ");
                    vehicleAdditions.add(addition);
                    break;
                case PARKINGSENSOR:
                    System.out.println("Adding a parking sensor");
                    vehicleAdditions.add(addition);
                    break; 
                case TOWBAR:
                    System.out.println("Adding a tow bar");
                    vehicleAdditions.add(addition);
                    break;
                case ROOFRACK:
                    System.out.println("Adding a roof rack");
                    vehicleAdditions.add(addition);
                    break;
                default: 
                    System.out.println("This addition is not suitable for this vehicle");
                    break; 
            }
    
        }
    }
}