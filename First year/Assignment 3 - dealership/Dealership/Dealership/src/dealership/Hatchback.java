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
 * *  Constructor for Hatchback objects
 * @param make make of hatchback
 * @param model model of hatchback
 * @param yearMade year hatchback was made
 * @param colour colour of hatchback
 * @param milage milage of hatchback
 * @param VIN Vehicle identification number of hatchback
 * @param gearType gear type of hatchback
 * @param satNav does it have a satnav
 * @param parkingSensor does it have a parking sensor
 * @param towBar does it have a towBar
 * @param roofRack does it have a roofRack
 */
    
    public Hatchback(String make, String model, int yearMade, Colour colour, int milage, String VIN, Gearbox gearType, boolean satNav, boolean parkingSensor, boolean towBar, boolean roofRack) {
        super(make, model, yearMade, colour, milage, VIN, gearType, satNav, parkingSensor, towBar, roofRack);
    }

    
}
