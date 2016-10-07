package Threads;

/**
 * Created by gvh574 on 10/6/2016.
 */
public class DeadLockThreadSand extends Thread{
//    Declare variables that are pass by reference
    Thread t;
//    The two objects that will be accessed by both the thread
    Object Lock1;
    Object Lock2;
//    Name of thread
    String threadName;

    DeadLockThreadSand(String name, Object Lock1, Object Lock2){
        this.Lock1 = Lock1;
        this.Lock2 = Lock2;
        threadName = name;
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if (t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }

        public void run() {
//            synchronized makes it so only this particular thread can access the object
            synchronized (Lock1) {
                System.out.println(threadName + ": Holding lock 1...");

                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println(threadName + ": Waiting for lock 2...");

//            synchronized makes it so only this particular thread can access the object
                synchronized (Lock2) {
                    System.out.println(threadName + ": Holding lock 1 & 2...");
                }
            }
        }

}
