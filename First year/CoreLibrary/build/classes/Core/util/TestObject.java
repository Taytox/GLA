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

   public class TestObject{
     long timeEnteredTheQueue; 
     long maximumTimeAllowedInQueue; 
     boolean hasBreached;
     int priorityLevel;

    public TestObject(int pl) {
      priorityLevel = pl;  
    }
     
     
    public boolean checkForBreach(){
        long currentTime = System.currentTimeMillis();
        
        if (currentTime - timeEnteredTheQueue > maximumTimeAllowedInQueue){
            hasBreached = true;
        }
       return hasBreached;
        
     }
    public boolean comparePriorityLevel(TestObject E){
        if(priorityLevel > E.priorityLevel){
        return true;
    }
        else{
            return false;
        }
        
    }
    }
     
