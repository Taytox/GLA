/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.util;
import java.util.LinkedList;
import java.util.Queue;
/**
 *  https://beginnersbook.com/2013/12/linkedlist-in-java-with-example/#add
 * @author Euan
 */
public class PriorityQueue {
   LinkedList<TestObject> tq = new LinkedList<TestObject>(); 
  
  
    public PriorityQueue(){
 
    }   
    
    public void additem(TestObject E){
        int index = 0;
        for(TestObject e : tq){
            if(e.comparePriorityLevel(E)){
               tq.add(index, E);
               return;
            }
            index++;
        }   
        tq.addLast(E);
    }
    
    public TestObject removeNextItem(){
        /**First need to check if any items in the queue have breached
       
        */
       for(TestObject e : tq){
            if(e.checkForBreach()){
                return e;
            }
        }
       return tq.pop();
    }
    }


  /*abstract class PrioritisableItem{
     long timeEnteredTheQueue; 
     long maximumTimeAllowedInQueue; 
     boolean hasBreached;
     int priorityLevel;
     
    public boolean checkForBreach(){
        long currentTime = System.currentTimeMillis();
        
        if (currentTime - timeEnteredTheQueue > maximumTimeAllowedInQueue){
            hasBreached = true;
        }
        
     }
    public boolean comparePriorityLevel(PrioritisableItem E){
        if(priorityLevel > E.priorityLevel){
        return true;
    }
        else{
            return false;
        }
        
    }
    }
     
    */ 
 

