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
    
    public static void main(String[] args) {
        // TODO code application logic here
        boolean exit = false; 
        int choice;
        double gross;

       
        while (exit == false){
            
            BankingApplication.Menus(1); //Display Main Menu
                choice = (int)getValidNumber(1,4,false); // get a valid number from the user between 1 and 4 which is not a valid money ammount. 
                switch(choice){
                    case(1):
                       BankingApplication.Menus(2); //promt user to enter their gross salary
                       gross = getValidNumber(0,0,true); // get a valid amount of money from the user. 
                       exit = true; 
                       
                }
        }
    }
    private static void Menus(int menu){
        switch (menu){
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
                System.out.println("2. Scotland \n ");
    }
                
        }
    private static double getValidNumber(int minimum, int maximum,boolean money){
    double input = 0;
    boolean validInput = false; 
    while (!validInput){
    while (!sc.hasNextDouble()){
        System.out.print("\nPlease enter a number between " + minimum + " and "+ maximum + " ");
        sc.next();
    }
    input = sc.nextDouble();
    
    if (money == true){
        if (input > 0){
        return input;
        } 
        else{
        System.out.print("\nPlease enter a number greater than " + minimum);
       }
    }
    else if (input > 0 && input <= maximum){
            validInput = true; 
            }
        else {
        System.out.print("\nPlease enter a number between " + minimum + " and "+ maximum + " ");
        }

    
}
    
    return input;
}
}
