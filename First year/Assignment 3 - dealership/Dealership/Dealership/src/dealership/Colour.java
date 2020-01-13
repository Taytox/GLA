/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 * Enum which holds the top 10 car colours in the uk for 2019, taken from https://www.buyacar.co.uk/cars/642/best-car-colours
 * @author Euan Luke
 */
public enum Colour {
BLACK("Black"),GREY("Grey"),WHITE("White"),BLUE("Blue"),SILVER("Silver"),RED("Red"),GREEN("Green"),ORANGE("Orange"),BRONZE("Bronze"),YELLOW("Yellow");
final private String displayName;

/**
 * This method sets a display name for each enum 
 * @param displayName Plain text display name for the enum
 */
Colour (String displayName){
    
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
