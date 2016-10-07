package Runnables;

/**
 * Created by gvh57 on 9/30/2016.
 */
public class TestRunnable {

        public static void main(String args[]) {
            ThreadSand R1 = new ThreadSand("Runnable-1");
            R1.start();

            ThreadSand R2 = new ThreadSand("Runnable-2");
            R2.start();

            ThreadSand R3 = new ThreadSand("Runnable-3");
            R3.start();
        }

}
