package Handlers;


/**
 * Created by gvh57 on 10/19/2016.
 */
public class ThreadSand extends Thread {
    private Thread t;
    private String threadName;

    ThreadSand(String name){
        threadName = name;
        System.out.println("Creating" + threadName);
    }

    public void run(){
        System.out.println("Running" + threadName);
    }

    public void start(){
        System.out.println("Starting" + threadName);
        if (t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
