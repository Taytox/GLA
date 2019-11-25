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
public class MortgageApplication {
    private int netSalary;
    private int grossSalary;
   
    public MortgageApplication(){
       netSalary = 0; 
       grossSalary = 0;
    }
    
    public void setNet(int newNet){
        netSalary = newNet;
    }
    public int getNet(){
        return netSalary;
    }
    
    public void setGross(int newGross){
        grossSalary = newGross;
    }
    public int getGross(){
        return grossSalary;
    }
    public void calcNetSalary(boolean TaxSystem){
        double taxableAmount = 0;
        int personalAllowance = 0;
        double taxAmount = 0;
        int niAmount = 0; 
        int[] scotTaxThresholds ={0,2049,12444,30930,150000}; // these are added to the applicants personal allowances to generate the thresholds, except for 150000 which is the flat limit for the top rate
        double[] scotTaxRates = {0,0.19,0.20,0.21,0.41,0.46};
        boolean scotlandTax = TaxSystem; //Is the user in England & Wales or Scotland. 
        
        if(grossSalary > 125000){ //If someone earns over £125,000 their personal allowance is £0
            personalAllowance = 0;
        }
        else if (grossSalary >=100000) //If someone earns over £100,000 then their personal allowance is reduced by £1 for ever £2 over until £125,000
        {
            int overrate = grossSalary - 100000; //finds out how much of the gross ammount is over 100000. 
            personalAllowance = 12500;
            while (overrate >= 1){  //while the ammount over £100,000 is greater than 1
                personalAllowance = personalAllowance -1; //remove £1 from the applicants personal allowance 
                overrate = overrate -2;  //take £2 off of the ammount. 
            }
        }
            else{ // if the applicant does not earn over £100,000 apply the default rate of £12,500
                    personalAllowance = 12500; 
                    }   
        
       if(scotlandTax == true) { //If the Applicant is located in Scotland an has to have scottish income tax applied
         
           for (int i = 1; i <= 4; i++){
            if (grossSalary >= personalAllowance + scotTaxThresholds[i]) //if their gross salary is less than their personal allowance and the current tax threshold
            {
                taxAmount = taxAmount + ((scotTaxThresholds[i] - scotTaxThresholds[i-1]) * scotTaxRates[i]); 
                System.out.println("The ammount that is taxible in tax bracket " + i + " is " + taxableAmount + "the ammount taxed is " + (int)taxAmount);
            }
            else if(grossSalary < personalAllowance + scotTaxThresholds[i])
            {
                taxableAmount  = (grossSalary - (personalAllowance + scotTaxThresholds[i-1]));
                taxAmount = taxAmount + (taxableAmount * scotTaxRates[i]);
                System.out.println("The final ammount that is taxible in tax bracket " + i + " is " + taxableAmount + "the ammount taxed is " + (int)taxAmount);
                break;
            }
            }
       }
           
           
           
           /* 
         //for (int i = 1;i < 5; i++){
             if (grossSalary < scotTaxThresholds[0]){
                 taxAmount = 0; 
             }
             if (grossSalary >= scotTaxThresholds[i] )
             {
                 taxableAmount = ((scotTaxThresholds[i] +1) - scotTaxThresholds[i-1]); //Finds the taxable amount inside this bracket
                 taxAmount = taxAmount + (taxableAmount * scotTaxRates[i]); // applys the tax rate to the taxable amount and increases the total amount of tax payable.
                 System.out.println("The ammount that is taxible in tax bracket " + i + " is " + taxableAmount + "the ammount taxed is " + (int)taxAmount);
                 
             }
             else if (grossSalary < scotTaxThresholds[i]) {
                 taxableAmount  = (grossSalary - scotTaxThresholds[i-1]);
                 taxAmount = taxAmount + (taxableAmount * scotTaxRates[i]);
                 System.out.println("The final ammount that is taxible in tax bracket " + i + " is " + taxableAmount + "the ammount taxed is " + (int)taxAmount);
                 break;
             }
            System.out.println ("Your personal allowence is " + personalAllowance); 

          } 
       }   
    } */
}
        //System.out.println(personalAllowance);
        //return netSalary;
    }