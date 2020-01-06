/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 *
 * @author Euan Luke
 */
public abstract class Car extends Vehicle {

    
    
/**
 * 
 * @param make
 * @param model
 * @param yearMade
 * @param colour
 * @param milage
 * @param VIN
 * @param gearType
 * @param additions 
 */
    public Car(String make, String model, int yearMade, Colour colour,double milage, int VIN, Gearbox gearType, PossibleAdditions... additions) {
        super(make, model, yearMade, colour, milage, VIN, gearType, additions);
   
    }
    /**
     * Changes the additions stored for a vehicle 
     * @param addition the addition to add.
     */
    public void changeAdditions(PossibleAdditions addition){
       
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
                    break; 
            }
    
        }
    }
}