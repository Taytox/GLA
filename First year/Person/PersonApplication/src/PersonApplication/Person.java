/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonApplication;

/**
 *
 * @author ezluke
 */
public class Person {
   private String firstName;
   private String lastName;
   private int age;
   private int weight;
   private int height; 
   private char gender; 
   private boolean hasSpouse;
   private Person spouse; 


public Person (String newFirst, String newLast, int newAge, int newWeight,int newHeight, char newGender){
firstName = newFirst;
lastName = newLast;
age = newAge; 
weight = newWeight;
gender = newGender;
height = newHeight;
}

public String getFirst(){
return firstName;
}
public String getLast(){
 return lastName;
}
public int getAge(){
return age; 
}
public String getSpouseName(){
   return spouse.getFullName(); 
}
public int getWeight(){
return weight; 
}
public char getGender(){
    return gender; 
}
public void setSpouse(Person newSpouse){
    spouse = newSpouse;
    hasSpouse = true;
}
public String getFullName(){
   return firstName + " " + lastName;
}
public boolean getStatus(){
    return hasSpouse;
}
public double bmi(){
   double heightM = ((double)height / 100); 
   double bmi = weight / (heightM * heightM);  
   return bmi; 
}
public void bmiCategory(){
double bmi = bmi();
String status;

if (bmi >= 30){
    status = "Obese";
}
else if (bmi >=25) {
    status = "Over weight";
}
else if (bmi >18.5){
    status = "Normal Weight";
}
else{
    status = "Underweight";
}

System.out.println("This persons BMI is " + bmi + " this is in the " + status + " Category");
}

public void getMarried(Person spouse){
   
 if (getStatus() == false && spouse.getStatus() == false && getAge() >= 18 && spouse.getAge() >= 18 )
 {
  setSpouse(spouse);
  spouse.setSpouse(this);
 System.out.println(this.getFullName() + " has married " + spouse.getFullName());
}
 else{
     
     if(getStatus() == true) {
         System.out.println("The marriage could not go ahead " + this.getFullName() + " is already married!");
     }
     if(spouse.getStatus() == true){
         System.out.println("The marriage could not go ahead " + spouse.getFullName() + " is already married!"); 
     }
     if(getAge() <18) {
         System.out.println("The marriage could not go ahead " + this.getFullName() + " is under 18");
     }
     if(spouse.getAge() <18) {
         System.out.println("The marriage could not go ahead " + spouse.getFullName() + " is under 18");
     }  
 }

}
 public void procreate(Person parent1,Person parent2){
     if (parent1.spouse == parent2.spouse){
         
         
     }
 
 }
}


