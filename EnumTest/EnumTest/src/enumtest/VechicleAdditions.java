/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumtest;

/**
 *
 * @author EZLuke
 */
public enum VechicleAdditions {
   SATNAV(" sat nav "), PARKINGSENSOR(" parking sensor "), TOWBAR(" tow bar "),ROOFRACK(" roof rack ");  
final private String displayName;

VechicleAdditions(String displayName){
    
    this.displayName = displayName; 
}

 public String getDisplayName(){
  return displayName;
}


}
