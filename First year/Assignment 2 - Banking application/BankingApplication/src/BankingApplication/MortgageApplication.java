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
    private static int netSalary;
    private static double grossSalary;
    private static int personalAllowance;
    
    /**
    * Constructor for the MortgageApplication Class
    */
    
    public MortgageApplication(){
       netSalary = 0; 
       grossSalary = 0;
    }
    
    /**
     * Sets the value of netSalary
     * 
     * @param newNet the value to set netSalary to.
     */
    
    public static void setNet(int newNet){
        netSalary = newNet;
    }
    
    /**
     * Method for accessing the netSalary field 
     * 
     * @return value held in netSalary
     */
    
    public static int getNet(){
        return netSalary;
    }
    
    /**
     * Sets the value of GrossSalary
     * @param newGross the value to set grossSalary too.
     */
    
    public static void setGross(double newGross){
        grossSalary = newGross;
    }
    
    /**
     * Returns the value held in GrossSalary. 
     * @return 
     */
    
    public static double getGross(){
        return grossSalary;
    }  
    
    /**
     * Calculates the applicants net salary
     * @param location <code>1</code> if user is located in England or wales, <code>2</code> if they are in Scotland. 
     * @param status <code>1</code> if user is self employed, <code>2</code> if not. 
     * @return the applicants net salary amount. 
     */
    
    public static double calcNetSalary(int location, int status){
        double incomeTax; 
        double nationalInsurance;
        double deductions;
        double netSalary;
        
        nationalInsurance = calcNI(status);
        calcPersonalAllowance();
        
    if(location == 2) { //If the Applicant is located in Scotland an has to have scottish income tax applied
        incomeTax = scottishIncomeTax();
        System.out.println("Using Scottish IncomeTax");
    } 
    else {
        
        incomeTax = englishIncomeTax();
        System.out.println("Using English IncomeTax");
    }
    deductions = incomeTax + nationalInsurance;
    netSalary = grossSalary - deductions;
        return netSalary;
    }
    
    /**
     * 
     */
    
    private static void calcPersonalAllowance(){
        if(grossSalary > 125000){ //If someone earns over £125,000 their personal allowance is £0
            personalAllowance = 0;
        }
        else if (grossSalary >=100000) //If someone earns over £100,000 then their personal allowance is reduced by £1 for ever £2 over until £125,000
        {
            double overrate = grossSalary - 100000; //finds out how much of the gross ammount is over 100000. 
            personalAllowance = 12500;
            while (overrate >= 1){  //while the ammount over £100,000 is greater than 1
                personalAllowance = personalAllowance -1; //remove £1 from the applicants personal allowance 
                overrate = overrate -2;  //take £2 off of the ammount. 
            }
        }
            else{ // if the applicant does not earn over £100,000 apply the default rate of £12,500
                    personalAllowance = 12500; 
                    }
    }
    
    private static double scottishIncomeTax(){
        /*
       This method takes a boolean to represnt which tax system needs to be used. It calculates their presonal tax allowence and then determines how much tax they pay in each band.   
       Scottish income tax results were tested against :  https://www.scotfact.com/ScottishTaxCalculator Rates taken from https://www.gov.uk/government/publications/rates-and-allowances-income-tax/income-tax-rates-and-allowances-current-and-past#tax-rates-and-bands. 
        */
        double taxableAmount = 0;
        double[] scotTaxThresholds ={0,2049,12444,30930,150000}; // these are added to the applicants personal allowances to generate the thresholds, except for 150000 which is the flat limit for the top rate
        double[] scotTaxRates = {0,0.19,0.20,0.21,0.41,0.46};
        double taxAmount = 0;

        for (int i = 1; i <= 4; i++){
            if (grossSalary >= personalAllowance + scotTaxThresholds[i]) //if their gross salary is less than their personal allowance and the current tax threshold
            {
                taxableAmount = (scotTaxThresholds[i] - scotTaxThresholds[i-1]); //Find out how much of the amount is taxable in this bracket
                taxAmount = taxAmount + (taxableAmount * scotTaxRates[i]);  //Times the ammount taxable by the tax rate. 
                
            if( i == 4 && grossSalary > 150000){ //Checks if the top rate of tax needs to be applied
                    taxableAmount = grossSalary - 150000; // take the top threshold away from the gross Salary to get the taxable amount. 
                    taxAmount = taxAmount + (taxableAmount * scotTaxRates[i+1]); // Times the taxable ammount by the top rate tax rate. 
            }
            }
            else if(grossSalary < personalAllowance + scotTaxThresholds[i])
            {
                if (grossSalary < personalAllowance){
                    taxableAmount = 0;
                    break;
                }
                taxableAmount  = (grossSalary - (personalAllowance + scotTaxThresholds[i-1])); //Find the difference between the gross Salary and the previous threshold + their personal allowance.
                taxAmount = taxAmount + (taxableAmount * scotTaxRates[i]); //Times the ammount taxable by the tax rate. 
                break;
            }
          
        }
  return taxAmount;
    }
    
    private static double englishIncomeTax(){
    /*
       This method takes a boolean to represnt which tax system needs to be used. It calculates their presonal tax allowence and then determines how much tax they pay in each band.   
       Scottish income tax results were tested against :  https://www.which.co.uk/money/tax/tax-calculators/income-tax-calculator-ad9xh2l9wxxr Rates taken from https://www.gov.uk/government/publications/rates-and-allowances-income-tax/income-tax-rates-and-allowances-current-and-past#tax-rates-and-bands. 
    */
    double taxableAmount = 0;  
    double[] engTaxThresholds ={0,37500,150000}; // these are added to the applicants personal allowances to generate the thresholds, except for 150000 which is the flat limit for the top rate
    double[] engTaxRates = {0,0.20,0.40,0.45}; 
    double taxAmount = 0;
    
            for (int i = 1; i <= 2; i++){
            if (grossSalary >= personalAllowance + engTaxThresholds[i]) //if their gross salary is less than their personal allowance and the current tax threshold
            {
                taxableAmount = (engTaxThresholds[i] - engTaxThresholds[i-1]); //Find out how much of the amount is taxable in this bracket
                taxAmount = taxAmount + (taxableAmount * engTaxRates[i]);  //Times the ammount taxable by the tax rate. 
                
            if( i == 2 && grossSalary > 150000){ //Checks if the top rate of tax needs to be applied
                    taxableAmount = grossSalary - 150000; // take the top threshold away from the gross Salary to get the taxable amount. 
                    taxAmount = taxAmount + (taxableAmount * engTaxRates[i+1]); // Times the taxable ammount by the top rate tax rate. 
            }
            }
            else if(grossSalary < personalAllowance + engTaxThresholds[i])
            {
                if (grossSalary < personalAllowance){
                    taxableAmount = 0;
                    break;
                }
                taxableAmount  = (grossSalary - (personalAllowance + engTaxThresholds[i-1])); //Find the difference between the gross Salary and the previous threshold + their personal allowance.
                taxAmount = taxAmount + (taxableAmount * engTaxRates[i]); //Times the ammount taxable by the tax rate. 
                break;
            }
    
    
  
    }
              return taxAmount;  
    }
    
    private static double calcNI(int status){
    double niAmount = 0;
    
        if (status == 1){ //if the user is Self Employed
            if (grossSalary > 50001){ 
                niAmount = ((grossSalary - 50000) * 0.02) +  3723.12 + 156 ;
            } 
            else if (grossSalary > 8632 ){
                niAmount = (grossSalary - 8632) * 0.09;
            }
            else {
                niAmount = 156;
            }
        }
        if (status == 2){ //if the user is employed
            if (grossSalary > 50001){
                niAmount = ((grossSalary - 50000) * 0.02) +  4964.16;
            } 
            else if (grossSalary > 8632 ){
                niAmount = (grossSalary - 8632) * 0.12;
            } 
            else{
                niAmount = 0;
            }
        }
    return niAmount;
    }
}    
