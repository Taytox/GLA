/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;

import Core.util.IOHelper;
import java.util.ArrayList;

/**
 *
 * @author Euan
 */
public class HospitalTriageSystem {
static ArrayList<Patient> patientList = new ArrayList<Patient>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean exit = false;
        while(exit == false){
            int choice = IOHelper.getMenuChoice("Hospital Triage system: ","Patient Records","Treatments","Exit"); //Displays Main Menu 
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
        }   
    }
    
    }
    static void addNewPatient(){
        
    String firstName;
    String lastName;
    int height;
    int weight;
    int index = 0;
    String PIN;
    Bloodtype ptBloodType;
    Bloodtype  AllBloodTypes[] = Bloodtype.values(); //creates an array of bloodtypes 
    String[] bloodTypes = new String[AllBloodTypes.length]; //creates a blank array string to contain blood types
    Gender ptGender;
    Gender  AvailbleGenders[] = Gender.values(); //creates an array of Genders
    String[] genderChoices = new String[AvailbleGenders.length];

    for(Bloodtype B : AllBloodTypes){
    bloodTypes [index] = B.toString();
    index++;
    }
    
    index = 0;
    for(Gender G : AvailbleGenders){
    genderChoices [index] = G.toString();
    index++;
    }
    
    
    firstName = IOHelper.getString("Please enter the patients first name: ",1,15);
    lastName = IOHelper.getString("Please enter the patients last name: ",1,15);
    height = IOHelper.getNumberAbove("Please enter the patients hight in CM",1);
    weight = IOHelper.getNumberAbove("Please enter the patients weight in KG",1);
    ptBloodType = Bloodtype.valueOf(IOHelper.getMultipleChoiceAnswer("Please select the patients blood type",bloodTypes));
    ptGender = Gender.valueOf(IOHelper.getMultipleChoiceAnswer("Please select the patients gender",genderChoices));
    PIN = firstName.charAt(0) + lastName + String.valueOf(patientList.size() + 1 ); //Sets the Patients PIN to be first inital + last name + a generated number to try and ensure uniqueness
    
    System.out.println(PIN);
    patientList.add(new Patient(firstName,lastName,height,weight,ptBloodType,ptGender,PIN));
    }
    static void listRegisteredPatients(){
    printPatientHeader();    
    String[] details = new String[7];    
    for(Patient P : patientList){
        details = P.toString().split("\\|");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %n", details[0],details[1],details[2],details[3],details[4],details[5],details[6]);        
    }    
    }
    static void printPatientHeader(){ 
    System.out.printf("%-160S%n","\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");    
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %n", "Patient ID", "First Name", "Last Name","Gender","Blood Type","BMI", "BMI Category");
    System.out.printf("%-160S%n","------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}

