package ThreadsRunnablesExecutorsHandlers;

/**
 * Created by Victoria on 27.09.2016.
 */

// Implements Runnable
public class ExecutorsHappy_RunnableExample implements Runnable {

    // Attribute
    private String threadID;

    // Constructor
    public ExecutorsHappy_RunnableExample(String threadID) {
        this.threadID = threadID;
    }

    // Overrides method run
    @Override
    public void run() {
        // Prints name and id
        System.out.println("Thread name is " + Thread.currentThread().getName() + ", Thread ID = " + threadID);
        getID();
    }

    // Method getID
    private void getID() {
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}