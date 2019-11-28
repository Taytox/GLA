/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingApplication;
import java.util.Scanner;
/**
 *
 * @author Euan
 */
public class BankingApplication {
    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean exit = false; 
        int choice;
        double gross;
        int location;
        int status; 
        double netMonthly;
        double costMonthly;

       
        while (exit == false){
            
            BankingApplication.menus(1); //Display Main Menu
                choice = (int)getValidNumber(1,4,false); // get a valid number from the user between 1 and 4 which is not a valid money ammount. 
                switch(choice){
                    case(1):
                       BankingApplication.menus(2); 
                       gross = getValidNumber(0,0,true);
                       MortgageApplication.setGross(gross);
                       BankingApplication.menus(3);
                       location = (int)getValidNumber(1,2,false);
                       BankingApplication.menus(4); 
                       status = (int)getValidNumber(1,2,false);
                       netMonthly = (MortgageApplication.calcNetSalary(location, status)) / 12;
                       System.out.printf( "Your monthly net salary is %.2f \n",netMonthly);
                       exit = true; 
                }
        }
    }
    /**
     * Displays menus as well as user prompts. 
     * 
     * @param menuCode determines which menu or prompt is required. 
     */
    private static void menus(int menuCode){
        switch (menuCode){
            case(1):
                System.out.println("\n\nWelcome to Tayside Bank! ");
                System.out.println("\nPlease select from the following options: ");  
                System.out.println("1. Check mortgage eligibility "); 
                System.out.println("2. Calculate your Net annual Salary "); 
                System.out.println("3. Calculate monthly loan repayments ");
                System.out.println("4. Exit\n");
                System.out.print("Enter your choice between 1 and 4 : ");
                break;
            case(2):
                System.out.print("Please enter your Gross Salary: ");
                break;
            case(3):
                System.out.println("\n Are you located in: ");
                System.out.println("1. England, Wales, NI");
                System.out.println("2. Scotland ");
                break;
            case(4):
                System.out.println("\n Are you self employed? ");
                System.out.println("1. Yes ");
                System.out.println("2. No ");
                break; 
    }
                
        }
    /**
     *  Verifies that the user has entered a valid number that is within a specified range
     *  
     * @param minimum the lowest number that will be accepted as valid
     * @param maximum the highest number that will be accepted as valid, 0 if money is true.
     * @param money <code>true</code> if the value is money, <code>false</code> otherwise
     * @return a valid number within the range required
     */
    private static double getValidNumber(int minimum, int maximum,boolean money){
    double input = 0;
    boolean validInput = false; 
    while (!validInput){
    while (!sc.hasNextDouble()){
        System.out.print("\nPlease enter a number between " + minimum + " and "+ maximum + " ");
        sc.next(); //if a number was not entered, clear buffer and take next input; 
    }
    input = sc.nextDouble();
    
    if (money == true){
        if (input > minimum){
        return input;
        } 
        else{
        System.out.print("\nPlease enter a number greater than " + minimum);
       }
    }
    else if (input >= minimum && input <= maximum){
            validInput = true; 
            }
        else {
        System.out.print("\nPlease enter a number between " + minimum + " and "+ maximum + " ");
        }

    
}
    
    return input;
}
}
