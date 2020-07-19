/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;

/**
 *
 * @author Euan
 */
public class Patient {
    
   private String firstName;
   private String lastName;
   private int heightInCM;
   private int weightInKG;
   private String PIN;//private identification number
   private Bloodtype patientBT;
   private Gender patientGender;
   private double BMI;
   private String BMICategory;

    public Patient(String firstName, String lastName, int heightInCM, int weightInKG,Bloodtype patientBT, Gender patientGender, String PIN ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInCM = heightInCM;
        this.weightInKG = weightInKG;
        this.patientBT = patientBT;
        this.patientGender = patientGender;
        this.PIN = PIN;
        setBMI();
        setBMICategory();

    }

   public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
   }
   public void setLastName(String newLastName){
        this.lastName = newLastName;
   }
   public void setHeight(int newHeight){
        this.heightInCM = newHeight;
   }
   public void setWeight(int newWeight){
        this.weightInKG = newWeight; 
   }
   
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getHeight(){
        return heightInCM;
    }
    public int getWeight(){
        return weightInKG;
    }
    public String getPIN(){
        return PIN;
    }
    private void setBMI(){
        BMI = weightInKG / ((heightInCM * 0.01) * (heightInCM * 0.01));
    }
    private void setBMICategory(){
        
        if (BMI< 18.5){
            BMICategory = "Underweight";
        }
        else if (BMI < 25){
            BMICategory = "Normal";
        }
        else if (BMI < 30){
            BMICategory = "Overweight";
        }
        else if (BMI > 30){
               BMICategory = "Obese";
        }
        
    }
    @Override
    public String toString() {
        return PIN + "|" + firstName+ "|" +lastName+ "|" + patientGender.toString()+ "|"+ patientBT.toString()+ "|"+ String.format("%.2f",BMI) + "|" +BMICategory;
    }

}
