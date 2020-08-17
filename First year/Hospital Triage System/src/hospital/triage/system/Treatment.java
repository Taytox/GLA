/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;
import Core.util.Pritorisation;
import java.util.Calendar;
/**
 *Treatment class used to create Treatment Objects
 * @author Euan
 */
public class Treatment implements Pritorisation {
    boolean breachedTargetTime; 
    Patient patientNeedingTreatment;
    long timeTriaged;
    long timeTreated;
    PriorityLevel plAssigned;
    /**
     * Getter for treatments assigned PL
     * @return Treatments PriorityLevel
     */
    @Override 
    public int getPriorityLevel(){
    return plAssigned.getPLNumber();
    }
    /**
     * Getter for breached Status of a treatment
     * @return Breached status
     */
    @Override
    public boolean getBreachedStatus() {
        return breachedTargetTime;
    }
    /**
     * Getter for maximum duration allowed for treatment
     * @return maximum duration 
     */
    @Override
    public long getMaximumDuration(){
        int duration = plAssigned.getDuration(); //get time in minutes. 
        return duration * 60000; 
    }
    
    /**
     * Get the time in Milliseconds that the treatment was entered into the list.
     * @return time in Milliseconds
     */
    @Override
    public long getTimeEnteredQueue(){
       return timeTriaged;
    }
    /**
     * Getter for breached status of treatment
     */
    @Override
    public void hasBreached(){
        breachedTargetTime = true;
    }
    /**
     * constructor for objects of the Treatment Class
     * @param patient
     * @param PL 
     */
    public Treatment(Patient patient,PriorityLevel PL) {
        this.patientNeedingTreatment = patient;
        this.plAssigned = PL;
    }
    /**
    * Setter for the time the treatment was carried out
    */
    @Override
    public void setTimeLeftQueue(){
        
       timeTreated = System.currentTimeMillis();
    }
    
    /**
     *Setter for the time that the treatment entered the list 
     */
    @Override
    public void setTimeEnteredQueue() {
       timeTriaged = System.currentTimeMillis();
       System.out.println("Entered Queue : " + timeTriaged);
    }
    /**
     * getter for the time that the treatment was triaged
     * @return time triaged in Milliseconds 
     */
    public long getTimeTriaged(){
        return timeTriaged;
    }
    /**
     * getter for the time that the treatment was carried out
     * @return time treatment was carried out in Milliseconds
     */
    public long getTimeTreated(){
        return timeTreated;
    }
    /**
     * To string method for objects of the treatment class
     * @return a string representation of a treatment object 
     */
    @Override
    public String toString(){
        
        String breachedStatus = "On Time"; 
        
        if(breachedTargetTime){
            breachedStatus = "Breached";  
        }
        
        return (plAssigned.toString()  + "|" + breachedStatus + "|" + patientNeedingTreatment.toString());
        
    }
}
