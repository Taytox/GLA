/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumtest;

import java.util.ArrayList;

/**
 *
 * @author EZLuke
 */
public class EnumTest {
protected ArrayList<VechicleAdditions> additions = new ArrayList<VechicleAdditions>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EnumTest test = new EnumTest();
        test.addAddition(VechicleAdditions.PARKINGSENSOR);
        test.addAddition(VechicleAdditions.SATNAV);
        test.addAddition(VechicleAdditions.TOWBAR);
        test.checkForAddition();
    }
    
    void addAddition(VechicleAdditions addition){
        
       
        additions.add(addition);
        
    }
    
    private void checkForAddition(){
    int count = 0;
    System.out.print("This Vechicle has the following addtions :");
    while (additions.size() > count) {
        
       System.out.print(additions.get(count).getDisplayName()); 
       count++;
    }
     
      }
}
      
    
  
