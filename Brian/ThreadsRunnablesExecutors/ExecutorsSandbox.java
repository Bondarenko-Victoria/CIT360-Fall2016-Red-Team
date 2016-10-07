/**
 * Created by Brian on 9/26/2015.
 */

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorsSandbox {
    public static void main (String[] args) {

        // Creates an executor.
        Executor anExecutor = Executors.newCachedThreadPool();


            // Creates a rerunnable thread.
            RunnableSandbox runnable1 = new RunnableSandbox();
            // The executor executes the runnable thread.
            anExecutor.execute(runnable1);

        try {
            for(int i = 1; i < 3; i++) {
                // Creates another instance of a runnable thread.
                RunnableSandbox runnable2 = new RunnableSandbox();
                // The executor executes the new instance of the runnable thread.
                anExecutor.execute(runnable2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






