/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Euan
 */
public class TriageQueue {
    
  ArrayList<Queue> tq = new ArrayList<Queue>(); 

    public TriageQueue(int numberOfQueues) {
        for (int i = 0; i < numberOfQueues +1; i++) {
        tq.add(new LinkedList());
        
        tq.get(1).peek();
    }     
        
    }

}
