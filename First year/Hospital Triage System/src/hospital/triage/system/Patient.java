/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;

/**
 *Patient class, used to create Patient Objects.
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

   
   /**
    * Constructor for Patient objects
    * @param firstName first name for patient
    * @param lastName second name for patient
    * @param heightInCM patients height in CM
    * @param weightInKG patients weight in KG
    * @param patientBT patients BloodType
    * @param patientGender Patients Gender
    * @param PIN Patients Id string
    */
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

    /**
     * Setter for first name
     * @param newFirstName first name to set
     */
   public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
   }
   
   /**
    * Setter for last name
    * @param newLastName last name to set
    */
   public void setLastName(String newLastName){
        this.lastName = newLastName;
   }
   
   /**
    *Setter for  height
    * @param newHeight height to set
    */
   public void setHeight(int newHeight){
        this.heightInCM = newHeight;
   }
   
   /**
    * Setter for weight
    * @param newWeight weight to be set
    */
   public void setWeight(int newWeight){
        this.weightInKG = newWeight; 
   }
   
   /**
    * Getter for patients first name
    * @return patients firstname;
    */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Getter for Patients lastname
     * @return Patients lastname
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * Getter for Patients Height
     * @return Patients Height
     * 
     */
    public int getHeight(){
        return heightInCM;
    }
    
    /**
     * Getter for Patients Weight
     * @return Patients Weight
     */
    public int getWeight(){
        return weightInKG;
    }
    
    /**
     * Getter for Patients ID 
     * @return Patients ID
     */
    public String getPIN(){
        return PIN;
    }
    
    /**
     * Setter for patients BMI
     */
    private void setBMI(){
        BMI = weightInKG / ((heightInCM * 0.01) * (heightInCM * 0.01));
    }
    
    /**
     * Getter for patients BMI Category 
     * @return 
     */
    public String getBMICategory(){
        return BMICategory;
    }
    
    /**
     * Set patients BMI Category
     */
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
    
    /**
     * Writes a patient object to a string
     * @return String representation of Patient Object
     */
    @Override
    public String toString() {
        return PIN + "|" + firstName+ "|" +lastName+ "|" + patientGender.toString()+ "|"+ patientBT.toString()+ "|"+ String.format("%.2f",BMI) + "|" +BMICategory;
    }

}
