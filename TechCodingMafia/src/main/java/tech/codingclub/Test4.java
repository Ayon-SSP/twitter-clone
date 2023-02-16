package tech.codingclub;
import java.util.Date;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args)
    {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Test 4 Running at " + new Date() + " sharp." );

        int  arr []  = {10,20,30,40};
        arr[3]=80;

        System.out.println("Last value of arr is : "+ arr[arr.length-1]);

        int marr [][] = {{1,2,3,4},{5,6,7,8}};

        System.out.println("Last column last row element : "+ marr[1][3]);

        Scanner scan = new Scanner(System.in);

        System.out.println("enter the number a : ");
        int  a = scan.nextInt();
        System.out.println("enter the number b : ");
        int  b = scan.nextInt();
        System.out.println("entered number is : "+(a+b));

    }
}
