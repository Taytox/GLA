
import Core.util.PriorityQueue;
import Core.util.*;
import hospital.triage.system.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Euan
 */
public class Test {
    public static void main(String[] args) {
        
        PriorityQueue Test = new PriorityQueue();
        
        Patient testP1 = new Patient("Dave", "Test1", 0, 0, Bloodtype.A_NEGATIVE, Gender.OTHER, "testPin1");
        Patient testP2 = new Patient("Dave", "Test2", 0, 0, Bloodtype.A_NEGATIVE, Gender.OTHER, "testPin2");
        Patient testP3 = new Patient("Dave", "Test3", 0, 0, Bloodtype.A_NEGATIVE, Gender.OTHER, "testPin3");
        Patient testP4 = new Patient("Dave", "Test4", 0, 0, Bloodtype.A_NEGATIVE, Gender.OTHER, "testPin4");
        Patient testP5 = new Patient("Dave", "Test5", 0, 0, Bloodtype.A_NEGATIVE, Gender.OTHER, "testPin5");
        Patient testP6 = new Patient("Dave", "Test6", 0, 0, Bloodtype.A_NEGATIVE, Gender.OTHER, "testPin6");
        Patient testP7 = new Patient("Dave", "Test7", 0, 0, Bloodtype.A_NEGATIVE, Gender.OTHER, "testPin7");
        Patient testP8 = new Patient("Dave", "Test8", 0, 0, Bloodtype.A_NEGATIVE, Gender.OTHER, "testPin7");
        
        
        Treatment test1 = new Treatment(testP1,PriorityLevel.TRIVIAL);
        Treatment test6 = new Treatment(testP6,PriorityLevel.URGENT);
        Treatment test2 = new Treatment(testP2,PriorityLevel.RESUSCITATION);
        Treatment test3 = new Treatment(testP3,PriorityLevel.URGENT);
        Treatment test7 = new Treatment(testP7,PriorityLevel.URGENT);
        Treatment test4 = new Treatment(testP4,PriorityLevel.STANDARD);
        Treatment test5 = new Treatment(testP5,PriorityLevel.URGENT);
        
       
             
        
        //   RESUSCITATION(0,0),EMERGENCY(1,2),URGENT(2,5),STANDARD(3,10),TRIVIAL(4,15);
        Test.additem(test1);
        Test.additem(test6);
        Test.additem(test2);
        Test.additem(test3);
        Test.additem(test7);
        Test.additem(test4);
        Test.additem(test5);
        
        HospitalTriageSystem.add
    }
    }

