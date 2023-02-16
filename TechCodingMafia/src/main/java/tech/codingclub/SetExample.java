package tech.codingclub;

import java.util.*;


public class SetExample {
    public static void main(String[] args) {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Set.java  Running at " + new Date() + " sharp." );
        ArrayList<String> email = new ArrayList<String>();
        email.add("contact@codingclub.tech");
        email.add("contact@codingclub.tech");
        email.add("contact@linkedin.com");
        email.add("contact@linkedin.com");
        email.add("support@codingclub.tech");
        email.add("admin@codingclub.tech");
        email.add("mohitkota70@gmail.com");
        email.add("hr@tiktok.com");
        email.add("admin@tiktok.com");
        ArrayList<String> blackListed = new ArrayList<String>();
        blackListed.add("admin@tiktok.com");
        blackListed.add("hr@tiktok.com");

        // creating a set
        Set<String> uniqueEmail = new HashSet<String>();
        // add the elements of array list
        uniqueEmail.add("hr@google.com");
        uniqueEmail.addAll(email);
        Iterator<String> it= uniqueEmail.iterator();
        while(it.hasNext())
        {
            System.out.println("Iterator showing :"+it.next());
        }

        // iterate over set
        for(String x:uniqueEmail)
        {
            System.out.println(x);
        }
        // size of set
        System.out.println("Size of set : "+uniqueEmail.size());
        uniqueEmail.remove("hr@google.com");
        System.out.println("  after removing     :hr@google.com");
        uniqueEmail.removeAll(blackListed);
        Iterator<String> iterator= uniqueEmail.iterator();
        while(iterator.hasNext())
        {
            System.out.println("Sending email to  :"+iterator.next());
        }
        if(uniqueEmail.contains("mohitkota70@gmail.com"))
        {
            System.out.println("Yes it's present ");
        }
        else
        {
            System.out.println("No it's not present");
        }

    }
}
