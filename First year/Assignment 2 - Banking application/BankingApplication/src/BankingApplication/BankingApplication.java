/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingApplication;

/**
 *
 * @author Euan
 */
public class BankingApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MortgageApplication myMApp = new MortgageApplication();
        myMApp.setGross(124000);
        myMApp.calcNetSalary(true,true); 
    }
    
}
