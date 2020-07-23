/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;
import java.util.LinkedList;
import java.util.Queue;
/**
 *  https://beginnersbook.com/2013/12/linkedlist-in-java-with-example/#add
 * @author Euan
 */
public class PriorityQueue {
   LinkedList<Pritorisation> pq = new LinkedList<Pritorisation>(); 
  
  
    public PriorityQueue(){
 
    }   
    
    public void additem(Treatment E){
        int index = 0;
        for(Treatment e : tq){
            if(e.comparePriorityLevel(E)){
               pq.add(index, E);
               return;
            }
            index++;
        }   
        tq.addLast(E);
    }
    
    public Treatment removeNextItem(){
        /**First need to check if any items in the queue have breached
       
        */
       for(Treatment e : tq){
            if(e.checkForBreach()){
                return e;
            }
        }
       return tq.pop();
    }
    
    public boolean checkForBreach(Treatment E){
        long currentTime = System.currentTimeMillis();
        
        if (currentTime - E.timeTreated > maximumTimeAllowedInQueue){
            hasBreached = true;
        }
       return hasBreached;
        
     }
    public boolean comparePriorityLevel(Pritorisation E, int index){
        if(pq.get(index).getPriorityLevel() > E.getPriorityLevel()){
        return true;
    }
        else{
            return false;
        }
        
    }
}
interface Pritorisation{
    
    public int getPriorityLevel();
    public boolean getBreachedStatus(); 
    

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
 

