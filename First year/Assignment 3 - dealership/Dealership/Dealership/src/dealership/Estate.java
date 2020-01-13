/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 * Estate class which extends Car
 * @author Euan Luke
 */
public class Estate extends Car{

    public Estate(String make, String model, int yearMade, Colour colour,double milage, String VIN, Gearbox gearType, PossibleAdditions... additions) {
        super(make, model, yearMade, colour,milage, VIN, gearType, additions);
    }
    /**
     *  Adds an addition to an estate object
     * @param addition the addition to be added
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
                case THIRDROWSEAT:
                    System.out.println("Adding a third row seat");
                    vehicleAdditions.add(addition);
                    break;
                default: 
                    System.out.println("This addition is not suitable for this vehicle");
                    break; 
            }
        }
    }
    
}
