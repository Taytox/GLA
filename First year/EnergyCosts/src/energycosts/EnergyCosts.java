/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package energycosts;
import java.util.Scanner;
/**
 *
 * @author ezluke
 */
public class EnergyCosts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String customerName;
        double dailyElectricity;
        double dailyGas;
        int electricCost;
        int gasCost;
        double vat = 0.05;
        int monthLength = 30;
        double gasCorrection = 1.02264;
        double calorific = 39.1;  
        double gasConverted;
        double gasBill; 
        double electricBill;
        double totalBill; 
        
Scanner input  = new Scanner(System.in);

        System.out.print("Please enter your name:");
        customerName=input.next();
        
        System.out.print("Please enter your daily electricity use (in KWh):");
        dailyElectricity = input.nextDouble();
        
        System.out.print("Please enter your daily gas use (in cubic meters):");
        dailyGas = input.nextDouble();
        
        System.out.print("Please enter the Cost of 1 KWh of electricity in pence:");
        electricCost = input.nextInt();
        
        System.out.print("Please enter the Cost of 1 KWh of gas in pence:");
        gasCost = input.nextInt();
        
        gasConverted = (dailyGas * gasCorrection * calorific) / 3.6;
        
        gasBill = gasConverted * gasCost;
        
        electricBill = dailyElectricity * electricCost;
        
        totalBill = (((electricBill + gasBill) / 100) * monthLength)* vat;
        
        System.out.println(customerName + " your total bill for the month is: £" + totalBill);
        
        if (totalBill > 50){
         System.out.print("Your bill is high, try switching off the lights!");
        }
        }
        
        
       
        
       
        
    
        
// TODO code application logic here
    }

 
    
    

