/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.util;

/**
 *
 * @author Euan
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class FileManager {
    
    /**
     * Returns a String Arraylist which each line of the file. 
     * @param filePath path to the file used for input
     * @return list containing the lines of the file. 
     */
    public static ArrayList<String> getFileByLine(String filePath){
        String currentLine; 
        ArrayList<String> lineList = new ArrayList<String>();
        
        try{
            File f = new File(filePath);
            BufferedReader in = new BufferedReader(new FileReader(f));
            
            while ((currentLine = in.readLine()) !=null) {
               lineList.add(currentLine);
            }
        } catch(IOException e){
            System.out.print("IO error");
        }
        return lineList;
        
    }
    
    public static void writeFileByLine(String filePath, ArrayList<String> toBeWritten){
        try{
            FileWriter writer = new FileWriter(filePath);  
            BufferedWriter buffer = new BufferedWriter(writer);  
            for(String line : toBeWritten){
            buffer.write(line);  
            buffer.newLine();
            }
             buffer.close();  
            System.out.println("Success");  
        } catch(IOException e){
            System.out.print("IO error");
        }
     
        
    }
    
}
