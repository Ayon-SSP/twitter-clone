package tech.codingclub;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class Test8 {
    public static void main(String[] args) {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Test 8 Running at " + new Date() + " sharp." );
        // creating the usage of linked list
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("This");
        ll.add("is");
        ll.add("How");
        ll.add("you");
        ll.add("code");
        ll.add("Linked List");

        String first = ll.getFirst();
        String last  = ll.getLast();
        System.out.println(first +":"+last+":"+ll.size());
        // Linked List size
        ll.size();
        // iterator for Linked List
        Iterator<String> iterator = ll.iterator();
        // printing the
        while(iterator.hasNext())
        {
            String data = iterator.next();
            System.out.println(data);
        }







    }
}
