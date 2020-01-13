/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 * Hatchback class which extends Car class
 * @author Euan Luke
 */
public class Hatchback extends Car {
/**
 *  Constructor for Hatchback objects
 * @param make make of hatchback
 * @param model model of hatchback
 * @param yearMade year hatchback was made
 * @param colour colour of hatchback
 * @param milage milage of hatchback
 * @param VIN Vehicle identification number of hatchback
 * @param gearType gear type of hatchback
 * @param additions any additions added to the hatchback
 */
    public Hatchback(String make, String model, int yearMade, Colour colour,double milage, String VIN, Gearbox gearType, PossibleAdditions... additions) {
        super(make, model, yearMade, colour,milage, VIN, gearType, additions);
    }
    
}
