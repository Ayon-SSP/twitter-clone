package tech.codingclub;

import java.util.Date;
import java.util.Scanner;

public class RunnableExample implements Runnable {

    private String threadName;
    public int counter;
    private int waitTimeWhileLoop;

    public RunnableExample(String threadName, int counter, int waitTimeWhileLoop) {
        this.threadName = threadName;
        this.counter = counter;
        this.waitTimeWhileLoop = waitTimeWhileLoop;
    }


    public void run()
    {
        while(counter<1000)
        {
            counter++;
            // sleep for some time
            System.out.println(threadName+" : "+counter);
            try {
                Thread.sleep(waitTimeWhileLoop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // we are overriding how run will going to work !!

    public static void main(String[] args) throws InterruptedException {

        System.out.println("This side is MOHIT.KOTA");
        System.out.println("Running Thread Example at "+ new Date());


        RunnableExample runnable1 = new RunnableExample("Thread_A",0,500);
        RunnableExample runnable2 = new RunnableExample("Thread_B",0,1000);
        RunnableExample runnable3 = new RunnableExample("Thread_C",0,2000);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        thread1.start();
        thread2.start();
        thread3.start();

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        // thread1.counter
//        System.out.println(runnable2.counter);
//        System.out.println(runnable3.counter);
//        System.out.println(runnable1.counter);
    }


}
