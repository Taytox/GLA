package Core.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Euan
 */
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author Euan Luke
 */
public class IOHelper {


static Scanner sc = new Scanner(System.in);


/**
 * Gets a string from the user
 * @return the string entered by the user
 */
public static String getString(String prompt,int minimumLength, int maxiumLength){
boolean validInput = false;
String input = null;
while (!validInput){
if (!prompt.equals("")){
        System.out.println("");
        System.out.println(prompt); 
    }
input = sc.nextLine(); 
if(input.length() < minimumLength){
    System.out.println("Sorry it must be at least " + minimumLength + " characters long");
}else if (input.length() > maxiumLength){
    System.out.println("Sorry it cant be more than " + maxiumLength + " characters long");
}else{
    validInput = true;
}
}
return input;

}

/**
* Gets a int from the user
* @return the int entered by the user. 
*/      
public static int getInt(){
int input = 0;
boolean validInput = false;
while(!validInput){
try{
    input = sc.nextInt(); 
    sc.nextLine();
    validInput = true; 
    
}catch(java.util.InputMismatchException e){
    System.out.print("Please enter a valid whole number : ");
    sc.nextLine(); //clears scanner buffer
}
}
return input; 
}

/**
 * Gets a int from the user that is between a lowest and hight value (inclusive)
 * @lowerLimit lowest correct value
 * @upperLimit Higher correct value
 * @return 
 */
public static int getNumberInRange(String prompt,int lowerLimit, int upperLimit){
int input = 0;
boolean validInput = false;
while(!validInput){
    if (!prompt.equals("")){
        System.out.println("");
        System.out.println(prompt); 
    }
    input = getInt(); 
    if(input >= lowerLimit & input <= upperLimit){
       
        validInput = true; 
    }else{
     System.out.println("Please enter a number between " + lowerLimit + " and " + upperLimit + ":");
    }
}
return input;
}

public static int getNumberAbove(String prompt,int limit){
int input = 0;
boolean validInput = false;
while(!validInput){
    if (!prompt.equals("")){
        System.out.println("");
        System.out.println(prompt); 
    }
    input = getInt(); 
    if(input >= limit){
       
        validInput = true; 
    }else{
     System.out.println("Please enter a number above " + limit + " : ");
    }
}
return input;

}

/**
 * Gets a Float from the user that is between a lowest and hight value (inclusive)
 * @lowerLimit lowest correct value
 * @upperLimit Higher correct value
 * @return 
 */
public static float getNumberInRange(String prompt,float lowerLimit, float upperLimit){
float input = 0;
boolean validInput = false;
while(!validInput){
    if (!prompt.equals("")){
    System.out.println("");
    System.out.print(prompt); 
    }
    
 input = getInt(); 
 if(input >= lowerLimit & input <= upperLimit){
     validInput = true; 
 }else{
     System.out.println("Please enter a number between " + lowerLimit + " and " + upperLimit + " :");
 }
}
return input;
}
/**
 * Reads a line from a file. Currently file has to be located in the project folder.
 *
 * @param fileName
 * @return 
 */
public static String getLineFromFile(String fileName){
    String data=""; 
        try{ 
            File input = new File(fileName);
            Scanner inputReader = new Scanner(input);
            while (inputReader.hasNextLine()){
                data = inputReader.nextLine();
            }
            inputReader.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return data;
   
}
/**
 * Prompts user to select a choice, returns an Int.
 * @param prompt
 * @param choices
 * @return 
 */
public static int getMenuChoice(String prompt,String ... choices){
    
    int choice;
    int choiceNumber = 0;
    System.out.println("");
    System.out.println(prompt);
    for (String i:choices){
       choiceNumber++;
       System.out.println(choiceNumber + ". "+  i);
       
    }
    System.out.println("");
    System.out.println("Enter the number of your choice below:" );
    choice = getNumberInRange("",1,choiceNumber);
    return choice;
}

public static String getMultipleChoiceAnswer(String prompt,String ... choices){
        
    int choice;
    int choiceNumber = 0;
    System.out.println("");
    System.out.println(prompt);
    for (String i:choices){
       choiceNumber++;
       System.out.println(choiceNumber + ". "+  i);
       
    }
    System.out.println("");
    System.out.println("Enter the number of your choice below:" );
    choice = getNumberInRange("",1,choiceNumber);
    return choices[choice-1];
}
public static boolean getYesNo(String prompt){
    int choice;
    System.out.println("");
    System.out.println(prompt);
    System.out.println("1. Yes");
    System.out.println("2. No");    
    System.out.println("");
    System.out.println("Enter the number of your choice below:" );
    choice = getNumberInRange("",1,2);
    if (choice == 1){
        return true;
    } else {
        return false;
    }
}

public static String getEnumChoice(Class<? extends Enum<?>> e,String prompt) {
    return getMultipleChoiceAnswer(prompt,Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new));
} 
}
