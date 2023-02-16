package tech.codingclub;

import java.util.*;


public class Test9 {
    public static void main(String[] args) {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Test 9 Running at " + new Date() + " sharp." );

        Map<String,String> CountryToCapital = new HashMap<String,String>();

        // this is how to add the elements in map
        CountryToCapital.put("india","Delhi");
        CountryToCapital.put("China","Beijing");
        CountryToCapital.put("Cannada","Ottawa");

        // find
        if(CountryToCapital.containsKey("Russia")) {
            System.out.println("Capital of india : " + CountryToCapital.get("Russia"));
        }
        else
        {
            System.out.println("Capital of russia is not present in database ");
        }
        // print all keys
        System.out.println("#################");
        for(String i:CountryToCapital.keySet())
        {
            System.out.print(i+" ");
        }
        System.out.println("#################");
        for(String i:CountryToCapital.values())
        {
            System.out.print(i+" ");
        }
        System.out.println("#################");
        for(String i:CountryToCapital.keySet())
        {
            System.out.println(i + ":" + CountryToCapital.get(i));
        }

        System.out.println(" ###############Entry set############# ");
        for(Map.Entry<String, String> x:CountryToCapital.entrySet())
        {
            System.out.println(x.getKey()+" "+x.getValue());
        }



    }
}
