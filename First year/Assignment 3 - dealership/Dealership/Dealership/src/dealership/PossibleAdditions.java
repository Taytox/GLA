/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 * Enum of the possible additions that can be added to vehicles
 * @author Euan Luke
 */
public enum PossibleAdditions {
   SATNAV("sat nav "), PARKINGSENSOR("parking sensor "), TOWBAR("tow bar "),ROOFRACK("roof rack "),
   DRIVETRAIN("All-Wheel drivetrain"),THIRDROWSEAT("third-row seat"), LUGGAGEBOX("luggage box");  
   final private String displayName;

/**
 * This method sets a display name for each enum 
 * @param displayName Plain text display name for the enum
 */
PossibleAdditions(String displayName){
    
    this.displayName = displayName; 
}

/**
 * Getter for the display name of the enum value
 * @return display name of enum
 */
public String getDisplayName(){
  return displayName;
}


}
