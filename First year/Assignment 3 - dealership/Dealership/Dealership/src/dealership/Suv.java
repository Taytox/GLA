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
/**
 * Constructor for SUV class 
 * @param make make of SUV
 * @param model Model of SUV
 * @param yearMade Year SUV was made
 * @param colour Colour of the SUV  
 * @param milage milage of the SUV
 * @param VIN Vehicle Identification Number of SUV  
 * @param gearType Gearbox Type of SUV
 * @param additions Any additions added to the SUV 
 */
    public Suv(String make, String model, int yearMade, Colour colour,double milage, String VIN, Gearbox gearType, PossibleAdditions... additions) {
        super(make, model, yearMade, colour,milage, VIN, gearType, additions);
    }
  
    /**
     * Allows additions to be added to SUV objects. Overwrites method in Car class
     * @param addition 
     */
    @Override
    public void addAddition(PossibleAdditions addition){
            
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
                case DRIVETRAIN:
                    System.out.println("Adding All-Wheel Drive Train");
                    vehicleAdditions.add(addition);
                    break;
                default: 
                    System.out.println("This addition is not suitable for this vehicle");
                    break; 
            }
    
        }
    }
}
