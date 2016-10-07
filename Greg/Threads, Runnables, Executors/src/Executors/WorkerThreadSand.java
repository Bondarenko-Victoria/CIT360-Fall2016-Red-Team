package Executors;

/**
 * Created by gvh57 on 10/6/2016.
 */
public class WorkerThreadSand implements Runnable {

    private String command;

    public WorkerThreadSand(String s) {
        this.command=s;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




    public String toString(){
        return this.command;
    }

}
