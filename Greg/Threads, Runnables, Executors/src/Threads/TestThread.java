package Threads;

/**
 * Created by gvh57 on 9/30/2016.
 */
public class TestThread {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();
    public static Object Lock3 = new Object();
    public static Object Lock4 = new Object();

    public static void main(String args[]) {
        ThreadSand T1 = new ThreadSand( "Thread-1");
        T1.start();

        ThreadSand T2 = new ThreadSand( "Thread-2");
        T2.start();

        ThreadSand T3 = new ThreadSand( "Thread-3");
        T3.start();


//        Synchronization working
        DeadLockThreadSand ThreadLock3 = new DeadLockThreadSand("ThreadLock3", Lock3, Lock4);
        ThreadLock3.start();

        DeadLockThreadSand ThreadLock4 = new DeadLockThreadSand("ThreadLock4", Lock3, Lock4);
        ThreadLock4.start();

//        Synchronization not working -- DeadLock
        DeadLockThreadSand ThreadLock1 = new DeadLockThreadSand("ThreadLock1", Lock1, Lock2);
        ThreadLock1.start();

        DeadLockThreadSand ThreadLock2 = new DeadLockThreadSand("ThreadLock2", Lock2, Lock1);
        ThreadLock2.start();

    }
}