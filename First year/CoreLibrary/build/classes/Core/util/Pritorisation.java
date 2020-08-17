/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.util;

/**
 * Interface to be implemented on objects that will be used with the PriorityList Class. 
 * @author Euan Luke
 */
public interface Pritorisation {
    public int getPriorityLevel();
    public boolean getBreachedStatus(); 
    public long getMaximumDuration();
    public long getTimeEnteredQueue();
    public void setTimeLeftQueue();
    public void setTimeEnteredQueue();
    public void hasBreached();
    

}

