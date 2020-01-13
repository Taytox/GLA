/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonApplication;

/**
 *
 * @author ezluke
 */
public class PersonTest {
    
    public static void main(String[] args) {
    Person Dave = new Person ("Dave","Thompson",22,80,180,'M');
    Person Sarah = new Person ("Sarah","Smith",20,45,140,'F');
    Person James = new Person ("James","Fooley",13,40,70,'M');
    
    Dave.getMarried(Sarah);
    Sarah.getMarried(James);
    }
   
}
