package tech.codingclub;
import java.util.Date;
public class Test2 {
    public static void main(String[] args)
    {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Test 2 Running at " + new Date() + " sharp." );
        // adding two numbers
        int a = 400;
        int b = 8;
        int c = a+b;
        // Print Sum
        System.out.println("sum of "+a+"+"+b+"="+c);

        // Wideing variable
        double wideningVariable = a;
        System.out.println("wideing variable "+wideningVariable);
        wideningVariable = a+0.1;
        System.out.println("modified widening variable is "+wideningVariable);
        // narrowing variable
        int narrowvariable = (int) wideningVariable;
        System.out.println("narrow variable : "+narrowvariable);

        // overflow variable
        int overflow = Integer.MAX_VALUE;
        System.out.println("Max value of Integer is : "+overflow);
        overflow+=4;
        System.out.println("Modied value of overflow : "+overflow);
    }
}
