/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Creates the Triage Queues for each priority. 
 * @author Euan
 */
public class TriageManager {      
    Queue<Treatment> resuscitationQueue = new LinkedList<Treatment>();
    Queue<Treatment> emergencyQueue = new LinkedList<Treatment>();
    Queue<Treatment> urgentQueue = new LinkedList<Treatment>();
    Queue<Treatment> standardQueue = new LinkedList<Treatment>();
    Queue<Treatment> trivialQueue = new LinkedList<Treatment>();
    
    public TriageManager() {

    }
    

    public Treatment getNextTreatment(){
        boolean foundNextPatient = false; 
        Treatment nextTreatment = null;
        
        //check each queue in order
        //if top entry has breached, return it as next treatment. 
        //
        
        while(!foundNextPatient){
            
            if(containsBreachedTreatment(resuscitationQueue)){
                nextTreatment = resuscitationQueue.remove();
            }
            else if(containsBreachedTreatment(emergencyQueue)){
                nextTreatment = emergencyQueue.remove();
            }
            else if(containsBreachedTreatment(urgentQueue)){
                nextTreatment = emergencyQueue.remove();
            }
            else if(containsBreachedTreatment(standardQueue)){
                nextTreatment = emergencyQueue.remove();
            }
            else if(containsBreachedTreatment(trivialQueue)){
                nextTreatment = emergencyQueue.remove();
            }
            
            
        
            
            
            
            
            
            
            
            
          //  resuscitationQueue.peek().hasBreached();
        }
            return nextTreatment;
        
    }
    
    private boolean containsBreachedTreatment(Queue <Treatment> toCheck){
        
        if(hasTreatmentQueued(toCheck)){
       return toCheck.peek().hasBreached();  
       }
    }
    private boolean hasTreatmentQueued(Queue <Treatment> toCheck){
        if (toCheck.peek() == null){
            return false; 
        }else{
            return true;
        }
        }
    private void checkBreachedStatus(Queue <Treatment> toCheck){
    resuscitationQueue.peek();
    emergencyQueue.peek();
    urgentQueue.peek();
    standardQueue.peek(); 
    trivialQueue.peek();
    }
}
