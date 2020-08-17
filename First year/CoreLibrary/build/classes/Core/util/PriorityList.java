/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.util;
import java.util.LinkedList;
import java.util.Iterator;
/**
 *  Priority List class, Used as a data structure to hold objects that implement the Pritorisation interface. 
 * @author Euan
 */

/**
 *
*/
public class PriorityList implements Iterable<Pritorisation> {
   LinkedList<Pritorisation> pq = new LinkedList<Pritorisation>(); 
  
  
    public PriorityList(){
 
    }  
    
    /**
     * Iterator method to allow for each operations to be run on Priority Lists
     * @return Pritorisation Object iterator
     */
    @Override
    public Iterator<Pritorisation> iterator() {
        return pq.listIterator(0);
    }
    
    /**
     * Adds an object to the priorityList, adds based on priority value on the object being added.
     * @param E Object to be added.
     */
    public void additem(Pritorisation E){
        int index = 0;
        for(Pritorisation e : pq){
            if(comparePriorityLevel(E,index)){
               pq.add(index, E);
               E.setTimeEnteredQueue();
               return;
            }
            index++;
        }   
        pq.addLast(E);
        E.setTimeEnteredQueue();
    }
    
    /**
     * Removes the next time, returns the highest priority Item that has been in the list for the longest time, unless another object has breached
     * @return The next object in the queue. 
     */
    public Pritorisation removeNextItem(){
    Pritorisation toBeRemoved;
    int index = 0;
        for(Pritorisation e : pq){
            checkForBreach(e);
            if (e.getBreachedStatus()){
            pq.get(index).setTimeLeftQueue();
            toBeRemoved = pq.get(index);
            pq.remove(index);
            return toBeRemoved; 
            
            }
        index++;
        }
        return pq.pop();
    }
    
    /**
     * Checks if object passed into the method has breached its maximum duration
     * @param E Object to be checked
     */
    public void checkForBreach(Pritorisation E){
        long currentTime = System.currentTimeMillis();
        System.out.println("System Time : " + currentTime);
        boolean breached = false;
        
        System.out.println(currentTime + "-" + E.getTimeEnteredQueue() + ":" + E.getMaximumDuration());
        if (currentTime - E.getTimeEnteredQueue()> E.getMaximumDuration()){
             E.hasBreached();
     }
    
    }
    
    /**
     * Compares the priority level of an object passed in against an object already in the list
     * @param E Object to be compared
     * @param index location of object in list to compare against.
     * @return <code>True<\code> if the item in the list has a lower priority level, <code>False<\code> otherwise
     */
    public boolean comparePriorityLevel(Pritorisation E, int index){
        if(pq.get(index).getPriorityLevel() > E.getPriorityLevel()){
        return true;
    }
        else{
            return false;
        }
        
    }
    
    /**
     * Prints the content of the PriorityList
     */
    public void printContents(){
       for(Pritorisation e : pq){
           checkForBreach(e);
            System.out.println(e.toString());
            }
    }
    
    /**
     * Checks if the priorityList is empty
     * @return <code>True<\code> if empty, <code>False<\code> otherwise
     */
    public boolean isEmpty(){
        if(pq.isEmpty()){
            return true;
        }
        return false;
    }
    
    /**
     * Checks the size of the priorityList
     * @return the size of the list
     */
    public int size(){
        return pq.size();
    }
    
    /**
     * Returns an object in the list
     * @param index location of the object to return
     * @return Object at index location 
     */
    public Pritorisation inspectItem(int index){
       return pq.get(index);
    }
    

}



