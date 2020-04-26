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

    private boolean satNav;
    private boolean parkingSensor;
    private boolean towBar;
    private boolean roofRack;
    
    
    
/**
 * Constructor for car objects. 
 *  @param make make of car 
 * @param model model of car
 * @param yearMade year car was made
 * @param colour colour of car
 * @param milage milage of car
 * @param VIN Vehicle Identification number of car
 * @param gearType gearbox type of the car
 * @param satNav does it have a satnav
 * @param parkingSensor does it have a parking sensor
 * @param towBar does it have a towBar
 * @param roofRack does it have a roofRack
 */
    public Car(String make, String model, int yearMade, Colour colour,int milage, String VIN, Gearbox gearType,boolean satNav,boolean parkingSensor,boolean towBar,boolean roofRack ) {
        super(make, model, yearMade, colour, milage, VIN, gearType);
        this.satNav = satNav;
        this.parkingSensor = parkingSensor;
        this.towBar = towBar;
        this.roofRack = roofRack;
    }
/**
 * Allows a satnav to be added
 */
    public void addSatNav() {
        satNav = true;
    }
/**
 * Allows a Parking sensor to be added
 */
    public void addParkingSensor() {
       parkingSensor = true;
    }
/**
 * Allows a towbar to be added
 */
    public void addTowBar() {
        towBar = true;
    }
/**
 * Allows a roofRack to be added
 */
    public void addRoofRack() {
        roofRack = true;
    }
 /**
  * returns a string made up of the additions the vehicle currently has. 
  * @return additions currently in place. 
  */
    public String getCurrentAdditions(){
        String additions = "";
        
        if(satNav){
            additions = additions + " Satnav";
        }
        if(parkingSensor){
            additions = additions + " Parking Sensor" ;
        }
        if (towBar){
             additions = additions + " Towbar" ;
        }
        if (roofRack){
            additions = additions + " Roofrack " ;
        }
        
        return additions;
 
    }
    

/**
 * Provides a string for the object. 
 * @return 
 */
    @Override
    public String toString() {
        
        return super.toString() +getCurrentAdditions();
                }
    
    
    /**
     * Returns which additions are still possible for the car. 
     * @return which additions are still possible for the car. 
     */
    @Override
    public String possibleadditions(){
        
        String additions = "";
        if(!satNav){
            additions = additions + "Sat Nav|";
        }
        if(!parkingSensor){
            additions = additions + "Parking Sensor|" ;
        }
        if (!towBar){
             additions = additions + "Towbar|" ;
        }
        if (!roofRack){
            additions = additions + "Roofrack|" ;
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
            case("Sat Nav"):
                addSatNav();
                break;
            case("Parking Sensor"):
                addParkingSensor();
                break;
            case("Towbar"):
                addTowBar();
                break;
            case("Roofrack"):
                addRoofRack();
                break;
        }
        
        
    }
        
}    
        

    
    
