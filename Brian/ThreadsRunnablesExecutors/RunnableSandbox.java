/**
 * Created by Brian on 10/07/2016.
 */
public class RunnableSandbox implements Runnable{

    public void run() {
        synchronized(this)
        {
            try {
                for (int i = 1; i < 3; i++) {
                    // Prints the thread ID and thread name
                    System.out.println("Thread ID: " + Thread.currentThread().getName());
                    // The thread goes to sleep
                    Thread.sleep(100);
                }
            }
            catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


