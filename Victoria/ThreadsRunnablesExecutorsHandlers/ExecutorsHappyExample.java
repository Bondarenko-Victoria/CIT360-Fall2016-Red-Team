package ThreadsRunnablesExecutorsHandlers;

/**
 * Created by Victoria on 27.09.2016.
 */

import java.util.concurrent.*;

public class ExecutorsHappyExample {

    public static void main(String[] args) throws InterruptedException {

        // Creates executor that will run 4 runnables at a time
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        try {
            // Runs 4 times
            for (int i = 0; i < 4; i++) {
                //Creates rerunnable thread
                ExecutorsHappy_RunnableExample rfee = new ExecutorsHappy_RunnableExample(" " + i);
                // Executor executes runnable thread
                executorService.execute(rfee);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Calls method shutdown
        executorService.shutdown();

        // Works till executor will not terminated
        while (!executorService.isTerminated()) {
        }

        System.out.println("All threads are finished");
    }

}