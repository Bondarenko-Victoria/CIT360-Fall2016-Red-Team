/**
 * Created by Brian on 11/12/2015.
 */
public class ThreadSandbox extends Thread{
    // Create 2 static variables.
    public static String one = "hello";
    public static String two = "good-bye";

    @Override
    public void run() {

        /* The "synchronized" keyword causes an executing thread to block while waiting
        *  for the lock associated with an object. It can be avoided when you have 2
        *  threads, and one of them executes first while the other sleeps and wakes when
        *  the other thread is done and also goes to sleep.
        */

        // Thread 1 accessing the String one variable.
        synchronized (one) {
            for (int i = 0; i < 2; i++) {
                // Display "Sad" 2 times
                System.out.println("Sad");
                try {
                    // Thread 1 goes to sleep.
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread 1 accessing the String called 'two'.
                synchronized (two) {
                }
            }
        }

        // Thread 2 accessing the String one variable.
        synchronized (one) {
            for (int i = 0; i < 2; i++) {
                // Display "Sad" 2 times
                System.out.println("Happy");
                try {
                    // Thread 2 goes to sleep a little bit longer than Thread 1
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread 2 accessing the String called 'two'.
                synchronized (two) {
                }
            }
        }
    }

    public static void main(String args[]) {

        // Create an instance of a thread.
        ThreadSandbox happyThread =  new ThreadSandbox();

        // Call to the run method to start both threads
        happyThread.start();

        // NASTY PATH

        /* If the run method is called again, it causes to throw
        * an IllegalThreadStateException
        */
        // happyThread.start();
    }
}
