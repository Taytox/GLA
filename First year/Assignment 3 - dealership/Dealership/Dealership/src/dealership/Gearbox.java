/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 *
 * @author EZLuke
 */
        
public enum Gearbox {
    MANUAL("Manual"),AUTOMATIC("Automatic"); 
     final private String displayName;

        
Gearbox(String displayName){
    
    this.displayName = displayName; 
}

public String getDisplayName(){
  return displayName;
}
}