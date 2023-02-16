package tech.codingclub;

import java.util.Date;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Test 5 Running at " + new Date() + " sharp." );

        int a = 10;
        int b = 20;
        System.out.println("Sum :"+(a+b));
        System.out.println("Subtraction : "+(a-b));
        System.out.println("Multiplication : "+(a*b));
        System.out.println("Division  : "+(a/b));
        System.out.println("Modulo : "+(a%b));


        double c = -20.20;
        System.out.println("Math.abs() : "+Math.abs(c));

        double d = Math.abs(c);
        System.out.println("Math.ceil() :"+Math.ceil(a+b));
        System.out.println("Math.floor() : "+Math.floor(a-b));
        System.out.println("Math.min() : "+Math.min(2,3));
        System.out.println("Math.max()  : "+Math.max(2,3));
        System.out.println("Math.abs() : "+Math.abs(a%b));


        System.out.println("Math.random() 0 to 1 : "+Math.random());
        int random = 10 + (int)(Math.random()*90);
        System.out.println("Math.randome 10 to 100 : "+ random);

        System.out.println("Math.pi : "+Math.PI);
        System.out.println("Math.pow : "+Math.pow(2,4));

        int e = 100;
        System.out.println("Post increment : "+ e++); // 100
        System.out.println("pre increment  : "+ ++e); // 102

        int i=1;
        int ans = 1;
        while(i<=5)
        {
            ans*=i;
            i++;
        }
        System.out.println("Factorial : "+ans);


    }
}
