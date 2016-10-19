package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * Source: https://www.javacodegeeks.com/2013/01/java-thread-pool-example-using-executors-and-threadpoolexecutor.html
 */
public class TestExecutor {

    public static void main(String[] args) {

//        create executor that will run 5 runnables at a time
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThreadSand(" " + i);
            executor.execute(worker);
        }
        executor.shutdown();

//        nasty path for executor
        try {
            ExecutorService nastyExecutor = Executors.newSingleThreadExecutor();
            nastyExecutor.execute(null);
        }catch (Exception e){
            System.out.println("Nulls don't work");
        }


        System.out.println("Finished all threads");

    }
}
