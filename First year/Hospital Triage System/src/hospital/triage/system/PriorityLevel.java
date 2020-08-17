/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.triage.system;

/**
 *Enum to hold Priority Levels 
 * @author Euan
 */
public enum PriorityLevel {
    RESUSCITATION(0,0),EMERGENCY(1,2),URGENT(2,5),STANDARD(3,10),TRIVIAL(4,15);
    private int plNumberIndicator;
    int maxDuration;
    /**
     * Constructor for PriorityLevel Enums
     * @param plNumber int representation of a PriorityLevel
     * @param duration int for the number of minutes before an object assigned this PL will breach.
     */
    PriorityLevel(int plNumber,int duration){
        this.plNumberIndicator = plNumber;
        this.maxDuration = duration;
    }
    
    public int getPLNumber(){
        return plNumberIndicator;
    }
    public int getDuration(){
        return maxDuration;
    }
    
}
