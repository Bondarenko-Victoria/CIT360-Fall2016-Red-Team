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
                    
                    //NASTY PATH
                      // NullPointerException when the thread holds a null lock.
                      // Thread.holdsLock(null);

                    // IllegalArgumentException: timeout value is negative when you pass
                    // a negative timeout value to join the threads.
                    //ThreadSandbox myThread = new ThreadSandbox();
                    //myThread.join(-1);
                }
            }
            catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


