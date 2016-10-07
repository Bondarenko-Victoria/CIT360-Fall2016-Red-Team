/*
 * Created by Brian on 9/30/2015.
 */

/* I created two threads, and each thread gets blocked. When both are blocked
* each waits for the other to release a lock. Since both threads have are blocked
* by 2 locks, they continue to wait for each other forever and cannot stop. */

public class NastyThreadSandbox extends Thread {

    // Creates an object and is saved in a static variable.
    public static Object ball = new Object();
    // Creates a string and is saved in a static variable.
    public static String greeting = "hello";

    @Override
    public void run() {

        /* The "synchronized" keyword causes an executing thread to block while waiting
        *  for the lock associated with an object.
        */

        /* Since both threads happen to try to access an object or string at the same time,
        *  they create a cross lock or 'deadlock' because they keep waiting for each other
        *  forever and cannot stop by themselves until you stop them manually.
        */

        // Thread 1 is accessing the object called 'ball'.
        synchronized (ball) {
            System.out.println("Thread 1: acessing the object");
            try {
                // Thread 1 goes to sleep
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread 1 is accessing the String that Thread 2 is currently accessing.
            synchronized (greeting) {
                System.out.println("Thread 1: trying to access the string that Thread 2 is accessing");
            }
        }

        // Thread 2 is accessing the String
        synchronized (greeting) {
            System.out.println("Thread 2: acessing the string");
            try {
                // Thread 2 goes to sleep for the same amount of time as Thread 1
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread 2 is accessing the object that Thread 1 is currently accessing.
            synchronized (ball) {
                System.out.println("Thread 2: trying to access the string that Thread 1 is accessing");
            }
        }
    }

    public static void main(String args[]) {

        // Create 2 threads.
        NastyThreadSandbox nastyThread1 =  new NastyThreadSandbox();
        NastyThreadSandbox nastyThread2 = new NastyThreadSandbox();

        // Call run method to start the threads
        nastyThread1.start();

        // NASTY PATH
        // Try to start the thread again throws an iLLegalThreadStateException
        //nastyThread2.start();
    }
}


