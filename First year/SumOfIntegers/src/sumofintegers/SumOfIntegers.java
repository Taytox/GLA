/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumofintegers;
import java.util.Scanner;
/**
 *
 * @author EZLuke
 */
public class SumOfIntegers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        task3();

    }

    public static void task1() {
        int sum = 0;
        int upperLimit = 100;
        int lowerLimit = 1;

        while (lowerLimit <= upperLimit) {
            sum = sum + lowerLimit;
            lowerLimit++;
        }
        System.out.println(sum);
    }
    public static void task2(){
        
        int sum = 0; 
        int upperLimit = 0;
        int lowerLimit = 0;
        boolean validInput = false;
        boolean validLower = false; 
        boolean validUpper= false;
        Scanner input  = new Scanner(System.in);
        while(validInput == false)
        {
            while(validLower == false){
            System.out.println("Please enter the lowest number of the range");
            lowerLimit=input.nextInt();
            if (lowerLimit <-50000){
                validInput = false;
                System.out.println("This number is too low, please enter a number above -50000");
            }
            else{
                validLower = true;
                } 
            }
            while(validUpper == false){
            System.out.println("Please enter the highest number of the range");
            upperLimit=input.nextInt();
             if (upperLimit > 50000){
                validUpper = false; 
                System.out.println("This number is too high please enter a number below 50000");
            }
            else{
                 
                validUpper = true;
                
                } 
            
             if (validLower && validUpper == true){
                 validInput = true;
             }
             }
        } 
        System.out.println("Your bottom number is " + lowerLimit);
        System.out.println("Your top number is " + upperLimit);
         while (lowerLimit <= upperLimit) {
            sum = sum + lowerLimit;
            lowerLimit++;
        }
        System.out.println("The sum of the integers between them is : " + sum );
        }
    public static void task3(){
        int sum = 0; 
        int upperLimit = 0;
        int lowerLimit = 0;
        int swap = 0;
        boolean validInput = false;
        boolean validLower = false; 
        boolean validUpper= false;
        Scanner input  = new Scanner(System.in);
        while(validInput == false)
        {
            while(validLower == false){
            System.out.println("Please enter the lowest number of the range");
            lowerLimit=input.nextInt();
            if (lowerLimit <-50000){
                validInput = false;
                System.out.println("This number is too low, please enter a number above -50000");
            }
            else{
                validLower = true;
                } 
            }
            while(validUpper == false){
                System.out.println("Please enter the highest number of the range");
                upperLimit=input.nextInt();
                
                if (upperLimit > 50000)
                {
                    validUpper = false; 
                    System.out.println("This number is too high please enter a number below 50000");
                }
                else
                {
                    validUpper = true;
                } 
             }
              if (validLower && validUpper == true){
                 validInput = true;
             }
              if(lowerLimit > upperLimit){
                  swap = lowerLimit;
                  lowerLimit = upperLimit;
                  upperLimit = swap; }
              else {
                  validInput = true;
              }
                  
                            
        } 
        System.out.println("Your bottom number is " + lowerLimit);
        System.out.println("Your top number is " + upperLimit);
         while (lowerLimit <= upperLimit) {
            sum = sum + lowerLimit;
            lowerLimit++;
        }
        System.out.println("The sum of the integers between them is : " + sum );
        }
    public static void task4(){
        
        
    }
    }
    
       