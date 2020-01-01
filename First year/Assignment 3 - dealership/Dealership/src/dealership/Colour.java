/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealership;

/**
 *
 * @author Euan Luke        
 */
public enum Colour {
    /*
    enum which holds the top 10 car colours in the uk for 2019, taken from https://www.buyacar.co.uk/cars/642/best-car-colours
    */
BLACK("black"),GREY("grey"),WHITE("white"),BLUE("blue"),SILVER("silver"),RED("red"),GREEN("green"),ORANGE("orange"),BRONZE("bronze"),YELLOW("yellow");
final private String displayName;

Colour (String displayName){
    
    this.displayName = displayName; 
}

public String getDisplayName(){
  return displayName;
}
}
