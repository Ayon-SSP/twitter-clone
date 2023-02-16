package tech.codingclub;
import java.util.*;

public class SortExample {
    public static void main(String[] args)
    {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("SortExample Running at " + new Date() + " sharp." );
        ArrayList<String> email = new ArrayList<String>();
        email.add("contact@codingclub.tech");
        email.add("support@codingclub.tech");
        email.add("admin@codingclub.tech");



        for(String i:email)
        {
            System.out.println(i);
        }
        Collections.sort(email);
        System.out.println(":::::::::After sorting ::::::::");
        for(String i:email)
        {
            System.out.println(i);
        }
        // normal array
        int arr[]  ={5,4,8,6,2,8,1,7,8,2};
        Arrays.sort(arr);
        for(int i : arr)
        {
            System.out.println(i);
        }


    }
}
