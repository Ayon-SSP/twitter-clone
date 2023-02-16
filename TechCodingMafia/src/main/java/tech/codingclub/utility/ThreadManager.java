package tech.codingclub.utility;

import tech.codingclub.RunnableExample;

import java.util.Date;

public class ThreadManager {

    public static void main(String[] args) {

        System.out.println("This side is MOHIT.KOTA");
        System.out.println("Running Thread Example at "+ new Date());


        TaskManager taskManager = new TaskManager(100);
        for(int i=0;i<1000;i++)
        {
            taskManager.waitTillQueueIsFreeAndAddTask(new RunnableExample("THREAD_NO"+i,0,500+i));
            System.out.println("$$$$$$$$$$$$$$ "+i);
            // Queue is heavy now pause with in this loop  !
        }
        System.out.println("###############################");
        // 1.we want to have our own task manager for N number of threads parallely
        // 2.Let say I want Main Thread to pause when  there is enough queue size !

    }
}
