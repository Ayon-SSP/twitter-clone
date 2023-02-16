package tech.codingclub;

import java.util.Date;

public class Debugging {

    public static void main(String[] args)
    {
        // sum of all natural number's till a number n
        int N=10;
        int sum=0;
        for(int i=0;i<=N;i++)
        {
           sum+=i;
        }
        System.out.println("sum till n numbers : "+sum);
        Singleton singleton=Singleton.getSingletonInstance(456);
        Singleton singletonsecond = Singleton.getSingletonInstance(106);
        System.out.println(singleton.data + sum );
        System.out.println(new Date().toString());
        System.out.println(singletonsecond.data+sum);
        int x=sum;
        int y=45; // 45
        int z=x+y;
        // run your code in a perfect way
        System.out.println(z+" must be 100 ");
    }
}
