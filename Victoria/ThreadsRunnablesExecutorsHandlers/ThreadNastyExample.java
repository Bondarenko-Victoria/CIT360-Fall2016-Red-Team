package ThreadsRunnablesExecutorsHandlers;

/**
 * Created by Victoria on 28.09.2016.
 */

/*
I have created two threads, and each thread is blocked. When both are blocked,
one expects to release the lock by another. Because both threads are blocked by
2 locks, they continue to wait for each other forever and can not stop.
They nee method join
 */

// Extends Thread
public class ThreadNastyExample extends Thread{

    // Creates 2 Objects
    public static Object one = new Object();
    public static Object two = new Object();

    // Attribute
    private String name;

    // Constructor
    public ThreadNastyExample(String name) {
        this.name = name;
    }

    // Method run
    public void run() {
        // Synchronized is kind of mutex
        // if it is free working thread block it to show that is busy
        synchronized (one) {
            System.out.println("Synchronized One: I’m " + this.name);

            try{
                // Thread goes to sleep
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (two) {
                System.out.println("Synchronized One(two): I’m " + this.name);
            }
        }

        synchronized (two) {
            System.out.println("Synchronized Two: I’m " + this.name);

            try{
                // Thread goes to sleep
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (one) {
                System.out.println("Synchronized Two(one): I’m " + this.name);
            }
        }
    }

    public static void main(String[] args) {
        // Creates the first thread
        ThreadNastyExample printer1 = new ThreadNastyExample("John");
        // Starts the first thread
        printer1.start();

        // Creates the second thread
        ThreadNastyExample printer2 = new ThreadNastyExample("Bob");
        // Starts the second thread
        printer2.start();
    }

}