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
    private boolean luggageBox;
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
    public Motorbike(String make, String model, int yearMade, Colour colour, int milage, String VIN, Gearbox gearType, boolean luggageBox){
        
        super(make, model, yearMade, colour, milage, VIN, gearType);
        this.luggageBox = luggageBox;
    } 
    
    public void addLuggageBox(){
        luggageBox = true;
    }
    
    public void removeLuggageBox(){
        luggageBox = false; 
    }
    
    public boolean hasLuggageBox(){
        
        return luggageBox;
    }
    
    @Override
    public String toString() {
        String addition;
        if(luggageBox){   
            return super.toString() + "Luggage box |";
        }else
            return super.toString() + "";
            
        }
      @Override
    public String possibleadditions(){
        String additions = "";
        if(!luggageBox){
            additions = additions + "Luggage Box|";
        }
        return additions;
    }
    
    @Override 
    public void modifyVehicle(String Addition){
    
        switch(Addition){
            case("Luggage Box"):
                addLuggageBox();
                break;
            case("remove"):
                removeLuggageBox();
                break;
        }
        
    }
}
