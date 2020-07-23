/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;
import java.util.Calendar;
/**
 *
 * @author Euan
 */
public class Treatment implements Pritorisation {
    boolean breachedTargetTime; 
    Patient patientNeedingTreatment;
    long timeTriaged;
    long timeTreated;
    PriorityLevel plAssigned;
    
    @Override 
    public int getPriorityLevel(){
    return plAssigned.getPLNumber();
    }
    
    @Override
    public boolean getBreachedStatus() {
        return breachedTargetTime;
    }
    
    @Override
    public long getMaximumDuration(){
        int duration = this.plAssigned.getDuration(); //get time in minutes. 
        return duration * 60000; 
    }
    
    @Override
    public long getTimeEnteredQueue(){
       return timeTriaged;
    }
    
    @Override
    public void hasBreached(){
        breachedTargetTime = true;
    }
    
    public Treatment(Patient patient) {
        this.patientNeedingTreatment = patient;
    }

    public void setTimeLeftQueue(){
        
       timeTreated = System.currentTimeMillis();
    }
    
    public void setTimeTriaged(long timeTriaged) {
        this.timeTriaged = timeTriaged;
    }
    
    public long getTimeTriaged(){
        return timeTriaged;
    }
    
    public long getTimeTreated(){
        return timeTreated;
    }
    
    
}
