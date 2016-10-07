package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * Source: https://www.javacodegeeks.com/2013/01/java-thread-pool-example-using-executors-and-threadpoolexecutor.html
 */
public class TestExecutor {

    public static void main(String[] args) {

        ExecutorService executor = new Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThreadSand(" " + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");

    }
}
