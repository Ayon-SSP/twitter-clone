package tech.codingclub;

import javax.swing.*;
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
        int x=100;
        Scanner sc = new Scanner(System.in);


        try {
            int y = sc.nextInt();
            int ans = x/y;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



        try{
            int arr[] = {23,23,23333};
            System.out.println(arr[100]);
        }
        catch (ArithmeticException e)
        {
            System.out.println("arthemetic exception here !");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("You mad accessing out of element ! ");
        }
        catch (Exception e)
        {
            System.out.println("caught !"+e.getClass());
        }
        finally {
            System.out.println("Inside finally !");
        }


    }
}
