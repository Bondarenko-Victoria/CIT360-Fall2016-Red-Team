package ThreadsRunnablesExecutorsHandlers;

/**
 * Created by Victoria on 27.09.2016.
 */

// Implements Runnable
public class RunnablesHappyExample implements Runnable {

    // Creates 2 Objects
    public static Object one = new Object();
    public static Object two = new Object();

    // Attribute
    private String name;

    // Constructor
    public RunnablesHappyExample(String name) {
        this.name = name;
    }

    // Overrides method run
    @Override
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
        RunnablesHappyExample printer1 = new RunnablesHappyExample("John");
        Thread thread1 = new Thread(printer1);
        // Starts the first thread
        thread1.start();
        try {
            // Method join helps to wait for finishing a thread
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Creates the second thread
        RunnablesHappyExample printer2 = new RunnablesHappyExample("Bob");
        Thread thread2 = new Thread(printer2);
        // Starts the second thread
        thread2.start();
    }

}