/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 * Enum of the possible gearbox types that can be added to vehicles
 * @author Euan Luke
 */
        
public enum Gearbox {
    MANUAL("Manual"),AUTOMATIC("Automatic"); 
     final private String displayName;

/**
 * This method sets a display name for each enum 
 * @param displayName Plain text display name for the enum
 */        
Gearbox(String displayName){
    
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