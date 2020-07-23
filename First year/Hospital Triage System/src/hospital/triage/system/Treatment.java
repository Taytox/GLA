/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;

/**
 *
 * @author Euan
 */
public class Treatment implements Pritorisation {
    boolean breachedTargetTime; 
    Patient patientNeedingTreatment;
    long timeTriaged;
    long timeTreated;
    
    @Override 
    public int getPriorityLevel(){
    
    }
    
    public Treatment(Patient patient) {
        this.patientNeedingTreatment = patient;
    }

    public boolean getBreachedStatus() {
        return breachedTargetTime;
    }
    
    public void setTreatmentTime(long timeTreated){
        this.timeTreated = timeTreated;
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
