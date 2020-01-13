/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 * Saloon Class that extends car
 * @author Euan luke
 */
public class Saloon extends Car{

    /**
     *  Constructor for saloon objects
     * @param make make of the saloon 
     * @param model model of the saloon
     * @param yearMade year the saloon was made
     * @param colour colour of the saloon
     * @param milage milage of the saloon
     * @param VIN Vehicle identification number of the saloon
     * @param gearType gearbox type fo the saloon
     * @param additions additions added to the saloon. 
     */
    public Saloon(String make, String model, int yearMade, Colour colour,double milage, String VIN, Gearbox gearType, PossibleAdditions... additions) {
        super(make, model, yearMade, colour,milage, VIN, gearType, additions);
    }
    
}
