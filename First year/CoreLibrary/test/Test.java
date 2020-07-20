
import Core.util.*;

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
        
        TestObject test1 = new TestObject(1);
        TestObject test2 = new TestObject(2);
        TestObject test4 = new TestObject(4);
        TestObject test3 = new TestObject(3);
        TestObject test5 = new TestObject(1);
        Test.additem(test1);
        Test.additem(test2);
        Test.additem(test3);
        Test.additem(test4);
        Test.additem(test5);
        
        System.out.print(Test.toString());
        
    }
    }

