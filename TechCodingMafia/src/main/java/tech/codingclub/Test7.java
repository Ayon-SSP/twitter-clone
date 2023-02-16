package tech.codingclub;

import java.util.ArrayList;
import java.util.Date;



public class Test7 {
    public static void main(String[] args) {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Test 7 Running at " + new Date() + " sharp.");

        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("Welcome ");
        arrayList.add("to");
        arrayList.add("the");
        arrayList.add("Java");
        arrayList.add("Code");
        String first = arrayList.get(0);
        // we have updated at index 2
        arrayList.set(2,"THE");
        String second = arrayList.get(2);
        System.out.println("Updated index element 2 : "+second);
        // size of array list

        int size = arrayList.size();

        // now we want to remove the last element
        arrayList.remove(size-1);
        // print all the single elements present in aray lis t
        for(int i=0;i<arrayList.size();i++)
        {
            System.out.print(arrayList.get(i)+" ");
        }

    }

}

