/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 *
 * @author Euan
 */
public class Motorbike extends Vehicle {

    public Motorbike(String make, String model, int yearMade, Colour colour, double milage, int VIN, Gearbox gearType, PossibleAdditions... additions) {
        super(make, model, yearMade, colour, milage, VIN, gearType, additions);
    }
    
}
