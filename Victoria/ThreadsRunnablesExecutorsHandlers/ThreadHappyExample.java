package ThreadsRunnablesExecutorsHandlers;

/**
 * Created by Victoria on 27.09.2016.
 */

// Extends Thread
public class ThreadHappyExample extends Thread {

    // Creates 2 Objects
    public static Object one = new Object();
    public static Object two = new Object();

    // Attribute
    private String name;

    // Constructor
    public ThreadHappyExample(String name) {
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
        ThreadHappyExample printer1 = new ThreadHappyExample("John");
        // Starts the first thread
        printer1.start();
        try {
            // Method join helps to wait for finishing a thread
            printer1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Creates the second thread
        ThreadHappyExample printer2 = new ThreadHappyExample("Bob");
        // Starts the second thread
        printer2.start();

    }

}