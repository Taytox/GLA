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

    private boolean hasThirdRowSeat;
    
    
    /**
    * Constructor for Estate objects. 
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
     * @param thirdRowSeat does it have a third row seat
     */
    public Estate(String make, String model, int yearMade, Colour colour, int milage, String VIN, Gearbox gearType, boolean satNav, boolean parkingSensor, boolean towBar, boolean roofRack, boolean thirdRowSeat) {
        super(make, model, yearMade, colour, milage, VIN, gearType, satNav, parkingSensor, towBar, roofRack);
        
        hasThirdRowSeat = thirdRowSeat;
        
    }
    public void addThirdRowSeat() {
       hasThirdRowSeat = true;
    }
    @Override
    public String toString() {
        String carAdditions;
        if(hasThirdRowSeat){
            return super.toString() + " Third row seat";
            }
         return super.toString();
    }
    @Override
    public String possibleadditions(){
        String additions = super.possibleadditions();
        if(!hasThirdRowSeat){
            additions = additions + "Third Row Seat|";
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
            case("Third Row Seat"):
                addThirdRowSeat();
                break;
        }
         super.modifyVehicle(Addition);
      
    }     
}