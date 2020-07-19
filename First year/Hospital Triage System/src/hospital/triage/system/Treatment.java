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
public class Treatment {
    boolean breachedTargetTime; 
    Patient patientNeedingTreatment;
    long timeTriaged;
    long timeTreated;

    public Treatment(Patient patient) {
        this.patientNeedingTreatment = patient;
    }

    public boolean getBreachedStatus() {
        return breachedTargetTime;
    }
    private void setTreatmentTime(long timeTreated){
        this.timeTreated = timeTreated;
    }

    public void setTimeTriaged(long timeTriaged) {
        this.timeTriaged = timeTriaged;
    }
    
    
    
}
