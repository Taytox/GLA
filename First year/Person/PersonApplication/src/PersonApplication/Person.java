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
public int getWeight(){
return weight; 
}
public char getGender(){
    return gender; 
}
public String getFullName(){
   return firstName + " " + lastName;
}
public boolean status(){
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

}


