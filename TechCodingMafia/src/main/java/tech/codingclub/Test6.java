package tech.codingclub;

import java.util.Date;

import java.util.Random;



public class Test6 {
    public static void main(String[] args) {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Test 6 Running at " + new Date() + " sharp." );

        // importing a random func
        Random random=new Random();
        // after it calling the next int for a given limit
        int value = random.nextInt(100);
        System.out.println("random number 0 to 99 : "+value);
        // 50 - 99
        int randomIntValueInRange = 50 + random.nextInt(50); // 49
        System.out.println("random number 50 to 99 "+randomIntValueInRange);

        // Learning strings

        String string = "Hello World";

        System.out.println("printing string : "+string);
        string+="!";
        System.out.println("Printing Modified string : "+string);

        // string Method

        System.out.println("String length : "+ string.length());
        System.out.println("string s(5,n : "+string.substring(5));
        System.out.println("String substring (5,7) where n is exclusive : "+string.substring(5,7));

        // upper case and lower case

        System.out.println("Upper Case : "+string.toUpperCase());
        System.out.println("Lower case : "+string.toLowerCase());

        int  data = string.indexOf('w');
        // return index of Char 'w'
        System.out.println("index of w is :"+data);
        char ch = string.charAt(6);
        // return the character present at index 6
        System.out.println("character present at index 6 is :"+ch);
        // to compare strings

        String s1 = "abc";
        String S2 = "abd";

        // if s1 > s2 returns +ve
        // if s1<s2 return -ve
        // if s1 == s2 returns 0
        System.out.println(s1.compareTo(S2));

        Date date = new Date();
        long previousEpocTime = new Date().getTime();
        //System.out.println(previousEpocTime);
        int sum = 0;
        for(int i=0;i<1000000000;i++)
        {

        }
        long currentEpocTime = new Date().getTime();
        System.out.println((-previousEpocTime+currentEpocTime) + " millsecond to run 10^6. ");

        System.out.println(new Date().toString());
        // because 1640621853369 is not fitting we just treat it as
        // long
        Date dateFromEpoch = new Date(1640621853369L);

        System.out.println(dateFromEpoch.toString());

        System.out.println("current time : "+new Date());


    }
}
