/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;

import Core.util.IOHelper;
import java.util.ArrayList;
import Core.util.PriorityList;
import Core.util.Pritorisation;

/**
 * Hospital triage class for assignment
 * @author Euan
 */
public class HospitalTriageSystem {
static ArrayList<Patient> patientList = new ArrayList<Patient>();
static ArrayList<Treatment>completedTreatments = new ArrayList<Treatment>();
static PriorityList WaitingForTreatment = new PriorityList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean exit = false;
        while(exit == false){
            int choice = IOHelper.getMenuChoice("Hospital Triage system: ","Patient Records","Treatments","Reports","Exit"); //Displays Main Menu 
            switch(choice){
                case(1): // User selects patient Records
                    choice = IOHelper.getMenuChoice("Patient Records: ","Register new patient","View existing Patient records","Exit"); //Displays patient record menu
                    switch(choice){
                        case(1):
                            addNewPatient();
                            break;
                        case(2): 
                            listRegisteredPatients();
                            break;   
                    }
                    break;
                case(2): //User selects Treatment
                    choice = IOHelper.getMenuChoice("Treatment Menu ","Treat next patient","Queue up new treatment","List pending treatments","List Completed Treatments","Return to Main Menu"); //Displays Treatment menu
                    switch(choice){
                        case(1):
                            treatNextPatient();
                            break;
                        case(2):
                            addNewTreatment();
                            break;
                        case(3):
                            listWaitingTreatments();
                            break;
                        case(4):
                            printCompletedTreatments();
                            break;
                            
                    }
                break;
                case(3): //user Selects reports
                    choice = IOHelper.getMenuChoice("Treatment Menu ","Number of patients waiting per priority level","Percentage of patients treated on time","Average Overwait","Number of completed patients by BMI","Return to Main Menu"); //Displays Reports menu   
                    switch(choice){                     
                        case(1):
                            CategoriseWaitingPatients();
                            break;
                        case(2):
                            calculateTreatmentsCompletedOnTime();
                            break;
                        case(3):
                            calculateAverageOverwaiting();
                            break;
                        case(4):
                            groupCompletedTreatmentsByBMI();
                            break;  
                    }
                break;
                case(4):
                    exit=true;
                    break;
            }   
    }
    
    }
    
    /**
     * Method for adding new patient objects to the Patient List
     */
    static void addNewPatient(){
        
    String firstName;
    String lastName;
    int height;
    int weight;
    String PIN;
    
    Bloodtype ptBloodType;
    ptBloodType = Bloodtype.valueOf(IOHelper.getEnumChoice(Bloodtype.class,"Please select the patients Blood Type."));


    Gender ptGender;
    ptGender = Gender.valueOf(IOHelper.getEnumChoice(Gender.class,"Please select the patients Gender."));
  
  
    firstName = IOHelper.getString("Please enter the patients first name: ",1,15);
    lastName = IOHelper.getString("Please enter the patients last name: ",1,15);
    height = IOHelper.getNumberAbove("Please enter the patients hight in CM",1);
    weight = IOHelper.getNumberAbove("Please enter the patients weight in KG",1);
   
    PIN = firstName.charAt(0) + lastName + String.valueOf(patientList.size() + 1 ); //Sets the Patients PIN to be first inital + last name + a generated number to try and ensure uniqueness
    
    patientList.add(new Patient(firstName,lastName,height,weight,ptBloodType,ptGender,PIN));
    
    }
    
    /**
     * Method to list all patients current held in the registered patientList
     */
    static void listRegisteredPatients(){
    printPatientHeader(); 
    
    if (patientList.isEmpty()){
        System.out.println("There are currently no registered Patients");
    }
    else{    
        for(Patient p : patientList ){
            printPatientDetails(p);
        }
        }
    }
    
    /**
     * Method to print the details of a single patient object held in the patient list
     * @param p patient object to print the details for 
     */
    static void printPatientDetails(Patient p){
    String[] details = new String[7];   
    details = p.toString().split("\\|");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %n", details[0],details[1],details[2],details[3],details[4],details[5],details[6]);
    }
    
    /**
     * Method to list all treatments currently held in the Waiting for treatment list
     */
    static void listWaitingTreatments(){ 
    printTreatmentHeader();
    if (WaitingForTreatment.isEmpty()){
        System.out.println("\nThere are currently no treatments waiting");
    }
    else{   
        
       
        for (Pritorisation t: WaitingForTreatment ){
            WaitingForTreatment.checkForBreach((Treatment)t);
            printTreatmentDetails((Treatment)t);
        
        }
    }
    }    
        
    /**
     * Method to print the details of a single treatment
     * @param T Treatment to print the details for
     */
    static void printTreatmentDetails(Treatment T){
    String[] details = new String[9];   
    details = T.toString().split("\\|");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %n", details[0],details[1],details[2],details[3],details[4],details[5],details[6],details[7],details[8]);   
    }
    
    /**
     * Method to print the connects of the completed treatments list
     */
    static void printCompletedTreatments(){
        printTreatmentHeader();
        if(completedTreatments.isEmpty()){
            System.out.println("No treatments have been completed");
        }else{
            for(Treatment T : completedTreatments){
                printTreatmentDetails(T);
            }
        }
    }
    
    /**
     * Method to treat the next patient in the watiting for treatment List
     */
    static void treatNextPatient(){
        if(!WaitingForTreatment.isEmpty()){
      completedTreatments.add((Treatment)WaitingForTreatment.removeNextItem());
        }else{
            System.out.println("\nThere are no pending treatments");
        }
    }
    
    /**
     * Method to check that a patientID entered matches one in the registered patients list. 
     * @param patientID Patient ID to check
     * @return <code>True<\code> if patient ID matches one for a patient in the list, <code>False<\code> otherwise
     */
    static boolean checkPatientID(String patientID){
    for(Patient p : patientList){
        if(p.getPIN().toLowerCase().equals(patientID.toLowerCase()))
            return true;
        }
    System.out.println("There is no patient with this ID");
    return false;    
    }
    
    /**
     * Method to create new treatment objects and add them to the waiting for treatment list
     */
    static void addNewTreatment(){
        
        boolean validPatientID = false;
        String patientID = "";
        Patient patientToTreat = null;
        if (patientList.isEmpty()){
            System.out.println("There are currently no registered Patients");
            return;
        }else{
            listRegisteredPatients();
            while(!validPatientID){
                patientID  = IOHelper.getString("please Enter the Patients ID", 1, 100);
                validPatientID = checkPatientID(patientID);
            }
        for(Patient p : patientList){
            if(p.getPIN().matches(patientID)){
                patientToTreat = p;
            }
        }
    PriorityLevel assignedPriority;
    assignedPriority = PriorityLevel.valueOf(IOHelper.getEnumChoice(PriorityLevel.class,"Please select the Priority Level of this treatment."));
    WaitingForTreatment.additem(new Treatment(patientToTreat,assignedPriority));
    

    
    }
    }
    
    /**
     * Method to calculate how many treatments in the waiting for treatment queue have each priority level assigned
     */
    static void CategoriseWaitingPatients(){
        int resuscitationWaiting = 0;
        int emergencyWaiting = 0;
        int urgentWaiting = 0;
        int standardWaiting = 0;
        int trivialWaiting = 0;

        for (Pritorisation t: WaitingForTreatment ){
            int currentPL;
            WaitingForTreatment.checkForBreach((Treatment)t);
            currentPL = t.getPriorityLevel();
             switch(currentPL){
                        case(0):
                            resuscitationWaiting++;
                            break;
                        case(1):
                            emergencyWaiting++;
                            break;
                        case(2):
                            urgentWaiting++;
                            break;
                        case(3):
                            standardWaiting++;
                            break;
                        case(4):
                            trivialWaiting++;
                            break;
           
             }
        }
    System.out.println("The ammount of patients waiting for Resucitation treatments : " + resuscitationWaiting );
    System.out.println("The ammount of patients waiting for Emergency treatments : " + emergencyWaiting );
    System.out.println("The ammount of patients waiting for Urgent treatments : " + urgentWaiting );
    System.out.println("The ammount of patients waiting for Standard treatments : " + standardWaiting );
    System.out.println("The ammount of patients waiting for Trivial treatments : " + trivialWaiting );
    }
    
    /**
     * Method to calculate how many completed treatments were completed by their deadline
     */
    static void calculateTreatmentsCompletedOnTime(){
        int amountTreatedOnTime = 0;
        int amountTreated = 0;
        float percentage= 0;
        
        if(completedTreatments.isEmpty()){
            System.out.println("No Treatments have been completed yet.");
            return;
        }else{
        for(Treatment T: completedTreatments){
            if(T.getPriorityLevel() != 0){
            if(!T.breachedTargetTime){
               amountTreatedOnTime++; 
            }
            amountTreated++;
            }
        }
    }
        percentage = (amountTreatedOnTime * 100) / amountTreated;
        
        System.out.println("So far,  " + amountTreated + " of patients not requiring resucitation have been treated. ");
        System.out.println("Of these patients, " + amountTreatedOnTime + " were treated on time" );
        String strPercentage = String.format("%.2f", percentage);
        System.out.println("This means that " + strPercentage +"% were treated on time" );

    }
    
    /**
     * Method to calculate what the average time a breach ticket had to wait. 
     */
    static void calculateAverageOverwaiting(){
    long totalOverWait = 0;
    int amountofBreaches =0;
    String averageWait ="";
    
           if(completedTreatments.isEmpty()){
            System.out.println("No Treatments have been completed yet.");
            return;
        }else{
        for(Treatment T: completedTreatments){
            if(T.getPriorityLevel() != 0){
            if(T.breachedTargetTime){
              totalOverWait = totalOverWait + (((T.timeTreated - T.timeTriaged) - T.getMaximumDuration()) /60000);
              amountofBreaches++;
            }
           
            }
        } 
        averageWait = String.format("%.2f", ((float)(totalOverWait / amountofBreaches)));
        System.out.println(amountofBreaches + " treatments have breached. The total amount of time treatments have breached for " + totalOverWait +" minutes.");
        System.out.println("The average overwait is : " + averageWait + " minutes");
    }
    }
    
    /**
     * Method for calculating how many treatments were carried out on each patient BMI
     */
    static void  groupCompletedTreatmentsByBMI(){
        
        String currentBMI = ""; 
        int obesePatients = 0;
        int overWeightPatients = 0;
        int normalPatients = 0;
        int underWeightPatients = 0;
        
        for(Treatment T: completedTreatments){
            currentBMI = T.patientNeedingTreatment.getBMICategory();
   
            if (currentBMI.equals("Underweight")){
                underWeightPatients++;
            }
            else if (currentBMI.equals("Normal")){
                normalPatients++; 
            }
            else if (currentBMI.equals("Overweight")){
                overWeightPatients++;
            }
            else if (currentBMI.equals("Obese")){
              obesePatients++;
            }
            
        } 
        System.out.println("The number of treatmeants recieved by obese patients :" + obesePatients );
        System.out.println("The number of treatmeants recieved by overweight patients :" + overWeightPatients );
        System.out.println("The number of treatmeants recieved by normal patients :" + normalPatients );
        System.out.println("The number of treatmeants recieved by underweight patients :" + underWeightPatients );;

        
    }
    
    /**
    *Method to print a standard formatted header when patient details need to be printed 
    */
    static void printPatientHeader(){ 
    System.out.printf("%-160S%n","\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");    
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %n", "Patient ID", "First Name", "Last Name","Gender","Blood Type","BMI", "BMI Category");
    System.out.printf("%-160S%n","------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    /**
    *Method to print a standard formatted header when Treatment details need to be printed 
    */
    static void printTreatmentHeader(){ 
    System.out.printf("%-160S%n","\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");    
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %n", "Priority Level","Breach Status","Patient ID", "First Name", "Last Name","Gender","Blood Type","BMI", "BMI Category");
    System.out.printf("%-160S%n","------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}

