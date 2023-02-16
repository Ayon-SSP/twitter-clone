package tech.codingclub;

import java.util.Date;
import java.util.Scanner;

public class ThreadExample extends Thread{

    private String threadName;
    public int counter;
    private int waitTimeWhileLoop;
    public ThreadExample(String threadName,int counter,int waitTimeWhileLoop)
    {
        this.threadName=threadName;
        this.counter=counter;
        this.waitTimeWhileLoop=waitTimeWhileLoop;
    }

    public void run()
    {
        // we will define what process we want to run parallely !!
        while(counter<1000)
        {
            counter++;
            // sleep for some time
            try {
                Thread.sleep(waitTimeWhileLoop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if(threadName.equals("Thread_A"))
//            {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(threadName.equals("Thread_B"))
//            {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(threadName.equals("Thread_C"))
//            {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(threadName+":"+counter);
        }
    }


    // we are overriding how run will going to work !!
    public static void main(String[] args) throws InterruptedException {

        System.out.println("This side is MOHIT.KOTA");
        System.out.println("Running Thread Example at "+ new Date());

        ThreadExample thread1 = new ThreadExample("Thread_A",0,500);
        ThreadExample thread2 = new ThreadExample("Thread_B",0,1000);
        ThreadExample thread3 = new ThreadExample("Thread_C",0,2000);
        ThreadExample thread4 = new ThreadExample("Thread_D",0,3000);

        thread1.start();
        thread2.start();
        thread3.start();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        // thread1.counter
        System.out.println(thread1.counter);
        System.out.println(thread2.counter);
        System.out.println(thread3.counter);
    }
}
